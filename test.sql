DROP TABLE IF EXISTS dossiers;

CREATE TABLE dossiers(
	id VARCHAR(36) PRIMARY KEY COMMENT '字符串唯一标识,主键',
	name VARCHAR(64) NOT NULL COMMENT '名称',
	sex INT(2) NULL DEFAULT '1' COMMENT '性别',
	address VARCHAR(128) NULL COMMENT '详细地址',
	phone varchar (11) NULL COMMENT '手机号码',
	email VARCHAR(64) NULL COMMENT '电子邮件',
	state INT(2) NOT NULL DEFAULT '1' COMMENT '状态',
	create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	remark VARCHAR(256) NULL COMMENT '备注'
);