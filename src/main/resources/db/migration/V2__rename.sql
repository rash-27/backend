
ALTER TABLE inventory DROP COLUMN condition;
ALTER TABLE inventory ADD COLUMN damaged_quantity INT NOT NULL DEFAULT 0;

ALTER TABLE supplier_active_dress_collection DROP COLUMN quantity;
ALTER TABLE supplier_active_dress_collection ADD COLUMN quality DECIMAL(5, 2) NOT NULL DEFAULT 0;

ALTER TABLE supplier_active_dress_collection ADD COLUMN no_of_times_bought DECIMAL(10, 2) NOT NULL DEFAULT 0;

