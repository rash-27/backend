CREATE TABLE IF NOT EXISTS employee (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL,
    address VARCHAR(500) NOT NULL,
    join_date DATE NOT NULL,
    salary DECIMAL(10,2) NOT NULL
);

CREATE TABLE IF NOT EXISTS employee_email (
    id SERIAL PRIMARY KEY,
    employee_id INT NOT NULL,
    email VARCHAR(255) NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES employee(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS employee_phone (
    id SERIAL PRIMARY KEY,
    employee_id INT NOT NULL,
    phone_number VARCHAR(12) NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES employee(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS employee_leave (
    id SERIAL PRIMARY KEY,
    employee_id INT NOT NULL,
    leave_date DATE NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES employee(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS dress (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    brand VARCHAR(255) NOT NULL,
    gender VARCHAR(10) NOT NULL,
    size VARCHAR(10) NOT NULL,
    color VARCHAR(50) NOT NULL,
    required_quantity INT NOT NULL
);

CREATE TABLE IF NOT EXISTS inventory (
    id SERIAL PRIMARY KEY,
    dress_id INT NOT NULL,
    available_quantity INT NOT NULL,
    purchase_date DATE NOT NULL,
    purchase_price DECIMAL(10,2) NOT NULL,
    selling_price DECIMAL(10,2) NOT NULL,
    condition VARCHAR(50) NOT NULL,
    FOREIGN KEY (dress_id) REFERENCES dress(id) ON DELETE RESTRICT
);


CREATE TABLE IF NOT EXISTS customer (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(500) NOT NULL,
    phone_number VARCHAR(12) UNIQUE NOT NULL,
    email VARCHAR(255),
    points INT NOT NULL
);

CREATE TABLE IF NOT EXISTS customer_transaction (
    id SERIAL PRIMARY KEY,
    customer_id INT NOT NULL,
    transaction_date DATE NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customer(id) ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS inventory_in_cust_transaction (
    id SERIAL PRIMARY KEY,
    inventory_id INT NOT NULL,
    customer_transaction_id INT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (customer_transaction_id) REFERENCES customer_transaction(id) ON DELETE CASCADE,
    FOREIGN KEY (inventory_id) REFERENCES inventory(id) ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS inventory_bought_by_customer (
    id SERIAL PRIMARY KEY,
    inventory_id INT NOT NULL,
    customer_id INT NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customer(id) ON DELETE CASCADE,
    FOREIGN KEY (inventory_id) REFERENCES inventory(id) ON DELETE RESTRICT
);


CREATE TABLE IF NOT EXISTS supplier (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(500) NOT NULL
);

CREATE TABLE IF NOT EXISTS supplier_phone (
    id SERIAL PRIMARY KEY,
    supplier_id INT NOT NULL,
    phone_number VARCHAR(12) NOT NULL,
    FOREIGN KEY (supplier_id) REFERENCES supplier(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS supplier_email (
    id SERIAL PRIMARY KEY,
    supplier_id INT NOT NULL,
    email VARCHAR(255) NOT NULL,
    FOREIGN KEY (supplier_id) REFERENCES supplier(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS supplier_transaction (
    id SERIAL PRIMARY KEY,
    supplier_id INT NOT NULL,
    transaction_date DATE NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (supplier_id) REFERENCES supplier(id) ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS inventory_in_supplier_transaction (
    id SERIAL PRIMARY KEY,
    inventory_id INT NOT NULL,
    supplier_transaction_id INT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (supplier_transaction_id) REFERENCES supplier_transaction(id) ON DELETE CASCADE,
    FOREIGN KEY (inventory_id) REFERENCES inventory(id) ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS inventory_bought_from_supplier (
    id SERIAL PRIMARY KEY,
    inventory_id INT NOT NULL,
    supplier_id INT NOT NULL,
    FOREIGN KEY (supplier_id) REFERENCES supplier(id) ON DELETE CASCADE,
    FOREIGN KEY (inventory_id) REFERENCES inventory(id) ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS supplier_active_dress_collection (
    id SERIAL PRIMARY KEY,
    supplier_id INT NOT NULL,
    dress_id INT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (supplier_id) REFERENCES supplier(id) ON DELETE CASCADE,
    FOREIGN KEY (dress_id) REFERENCES dress(id) ON DELETE RESTRICT
);



CREATE TABLE IF NOT EXISTS other_transaction (
    id SERIAL PRIMARY KEY,
    transaction_date DATE NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    description VARCHAR(500) NOT NULL
);