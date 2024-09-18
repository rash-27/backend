package com.dbms.backend.repo.transaction;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dbms.backend.models.stock.StockDescriptionSupplier;
import com.dbms.backend.models.transaction.SupplierTransaction;

@Repository
public class SupplierTransactionRepo {
    private JdbcTemplate jdbcTemplate;

    SupplierTransactionRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void addSupplierTransaction(SupplierTransaction supplierTransaction) {
        try {
            // Add in Supplier Transaction
            String supplier_transaction = "INSERT INTO supplier_transaction (supplier_id, transaction_date, amount) VALUES (?, ?, ?)";
            jdbcTemplate.update(supplier_transaction, supplierTransaction.supplier_id(), supplierTransaction.transaction_date(), supplierTransaction.amount());

            int id = jdbcTemplate.queryForObject("SELECT MAX(id) FROM supplier_transaction", Integer.class);

            // Updating and adding stock to supplier and inventory to supplier_inventory

            for(StockDescriptionSupplier stockDescriptionSupplier : supplierTransaction.StockDescriptionSupplier()) {

                // Adding the quality of dress in for a supplier
                String dressQuality = "UPDATE supplier_active_dress_collection SET quality = (quality * no_of_times_bought + ?) / (no_of_times_bought + 1), no_of_times_bought = no_of_times_bought + 1 WHERE supplier_id = ? AND dress_id = ?";
                jdbcTemplate.update(dressQuality, stockDescriptionSupplier.quality(), supplierTransaction.supplier_id(), stockDescriptionSupplier.dress_id());
                // Inventory in supplier transaction
                String stockSql = "INSERT INTO inventory_in_supplier_transaction (inventory_id, supplier_transaction_id, quantity) VALUES (?, ?, ?)";
                jdbcTemplate.update(stockSql, stockDescriptionSupplier.id(), id, stockDescriptionSupplier.available_quantity() + stockDescriptionSupplier.damaged_quantity());

                // Inventory bought by supplier
                String inventory_bought_by_supplier = "INSERT INTO inventory_bought_by_supplier (supplier_id, inventory_id) VALUES (?, ?)";
                jdbcTemplate.update(inventory_bought_by_supplier, supplierTransaction.supplier_id(), stockDescriptionSupplier.id());

                // Check if stock exists such that same dress id on same date
                String checkStock = "SELECT * FROM stock WHERE dress_id = ? AND purchase_date = ?";
                StockDescriptionSupplier stock = jdbcTemplate.query(checkStock, (rs, rowNum) -> new StockDescriptionSupplier(rs.getInt("id"), rs.getInt("dress_id"), rs.getInt("available_quantity"), rs.getDate("purchase_date").toLocalDate(), rs.getDouble("purchase_price"), rs.getDouble("selling_price"), rs.getInt("damaged_quantity"), 0), stockDescriptionSupplier.dress_id(), stockDescriptionSupplier.purchase_date()).stream().findFirst().orElse(null);
                if(stock == null){
                    // Insert new stock
                    String insertStock = "INSERT INTO stock (dress_id, available_quantity, purchase_date, purchase_price, selling_price, damaged_quantity) VALUES (?, ?, ?, ?, ?, ?)";
                    jdbcTemplate.update(insertStock, stockDescriptionSupplier.dress_id(), stockDescriptionSupplier.available_quantity(), stockDescriptionSupplier.purchase_date(), stockDescriptionSupplier.purchase_price(), stockDescriptionSupplier.selling_price(), stockDescriptionSupplier.damaged_quantity());
                }else {
                    // Update stock
                    String updateStock = "UPDATE stock SET available_quantity = available_quantity + ?, damaged_quantity = damaged_quantity + ? WHERE id = ?";
                    jdbcTemplate.update(updateStock, stockDescriptionSupplier.available_quantity(), stockDescriptionSupplier.damaged_quantity(), stock.id());
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
