INSERT INTO company (id, name, address)
VALUES (unhex(replace(UUID(), '-', '')), 'Baidu', '北京市');
# 
INSERT INTO company (id, name, address)
VALUES (unhex(replace(UUID(), '-', '')), 'Ali', 'beijing');

INSERT INTO company (id, name, address)
VALUES (unhex(replace(UUID(), '-', '')), 'Tencent', '北京市海淀区');

INSERT INTO company (id, name, address)
VALUES (unhex(replace(UUID(), '-', '')), 'BJTU', '');

INSERT INTO company (id, name, address)
VALUES (unhex(replace(UUID(), '-', '')), 'MyOwnCompany-1', 'MyOwnCompany-1\'s Address ');
#
# INSERT INTO company (name, address)
# VALUES ('Baidu', '北京市');
#
# INSERT INTO company (name, address)
# VALUES ('Ali', 'beijing');
#
# INSERT INTO company (name, address)
# VALUES ('Tencent', '北京市海淀区');
#
# INSERT INTO company (name, address)
# VALUES ('BJTU', '');
#
# INSERT INTO company (name, address)
# VALUES ('MyOwnCompany', 'MyOwnCompany\'s Address ');
select * from company;