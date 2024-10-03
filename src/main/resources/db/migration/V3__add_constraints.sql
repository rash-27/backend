ALTER TABLE employee_email ADD CONSTRAINT unique_employee_email UNIQUE (employee_id, email);
ALTER TABLE employee_phone ADD CONSTRAINT unique_employee_phone UNIQUE (employee_id, phone_number);
ALTER TABLE employee_leave ADD CONSTRAINT unique_employee_leave UNIQUE (employee_id, leave_date);

ALTER TABLE supplier_phone ADD CONSTRAINT unique_supplier_phone UNIQUE (supplier_id, phone_number);
ALTER TABLE supplier_email ADD CONSTRAINT unique_supplier_email UNIQUE (supplier_id, email);