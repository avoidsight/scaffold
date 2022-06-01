CREATE TABLE `rental_unit` (
                               `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id作为主键',
                               `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '单位名称',
                               `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '单位地址',
                               `status` tinyint DEFAULT 0 COMMENT '0:白名单,1:黑名单',
                               `legal` varchar(10) DEFAULT NULL COMMENT '法人代表',
                               `register_funds` decimal(18,4) DEFAULT NULL COMMENT '注册资金',
                               `self_frog` decimal(18,4) DEFAULT NULL COMMENT '自有盘扣',
                               `remark` varchar(255) DEFAULT NULL COMMENT '备注',
                               `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                               `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                               `update_by` varchar(64) DEFAULT '' COMMENT '更新人',
                               `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                               `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
                               PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='租赁商';
COMMIT;

-- ----------------------------
-- Records of manufacturer
-- ----------------------------
CREATE TABLE `manufacturer` (
                                `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id作为主键',
                                `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '单位名称',
                                `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '单位地址',
                                `legal` varchar(10) DEFAULT NULL COMMENT '法人代表',
                                `register_funds` decimal(18,4) DEFAULT NULL COMMENT '注册资金',
                                `contacts` varchar(255) DEFAULT NULL COMMENT '联系人',
                                `contact_phone` varchar(64) DEFAULT '' COMMENT '联系方式',
                                `remark` varchar(255) DEFAULT NULL COMMENT '备注',
                                `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                                `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                `update_by` varchar(64) DEFAULT '' COMMENT '更新人',
                                `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='生产商';
COMMIT;

CREATE TABLE `contract` (
                            `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id作为主键',
                            `type` tinyint NOT NULL COMMENT '0:采购,1:租赁,2:外借,3:寄存',
                            `contract_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '合同名称',
                            `warehouse_id` bigint COMMENT '仓库id',
                            `project_id` bigint COMMENT '项目id',
                            `in_time` date COMMENT '进入时间',
                            `out_time` date COMMENT '退出时间',
                            `resources` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '附件(,分割)',
                            `contract_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '合同编码',
                            `business_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '业务单号',
                            `form_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '表单编号',
                            `dept_id` bigint COMMENT '单位id',
                            `customer_id` bigint COMMENT '客户id',
                            `start_time` date COMMENT '开始日期',
                            `end_time` date COMMENT '结束日期',
                            `address` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '地址',
                            `link_man` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '联系人',
                            `link_phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '联系电话',
                            `operator` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '经办人',
                            `template_id` bigint COMMENT '计费模板id',
                            `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                            `update_by` varchar(64) DEFAULT '' COMMENT '更新人',
                            `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                            `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='合同表';

COMMIT;

CREATE TABLE `inventory` (
                             `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id作为主键',
                             `contract_id` bigint NOT NULL COMMENT '合同id',
                             `stock_type` TINYINT NOT NULL COMMENT '0: 入库, 1: 出库',
                             `car_rental_fee` decimal(18,2) DEFAULT 0 COMMENT '出租运费',
                             `loading_fee` decimal(18,2) DEFAULT 0 COMMENT '装车费',
                             `unloading_fee` decimal(18,2) DEFAULT 0 COMMENT '卸车费',
                             `origin` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '线路起点',
                             `destination` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '线路终点',
                             `transportation_unit_price` decimal(10,2) DEFAULT 0 COMMENT '运输单价，元/吨',
                             `transport_unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '运输单位',
                             `car_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '车牌号',
                             `freight` decimal(18,2) DEFAULT NULL COMMENT '运输费',
                             `lessor_theoretical_weight` decimal(18,2) DEFAULT NULL COMMENT '出租方理论重量，公斤，整车重量',
                             `supplier_theoretical_weight` decimal(18,2) DEFAULT NULL COMMENT '供应商理论重量，公斤，整车重量',
                             `warehouse_weight` decimal(18,2) NOT NULL DEFAULT 0 COMMENT '仓库称重',
                             `scene_weight` decimal(18,2) NOT NULL DEFAULT 0 COMMENT '场地称重',
                             `total_miscel_fee` decimal(18,2) DEFAULT NULL COMMENT '总杂费，元',
                             `operator` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '经办人',
                             `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
                             `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                             `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                             `update_by` varchar(64) DEFAULT '' COMMENT '更新人',
                             `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                             `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='库存出入库总表';

CREATE TABLE `inventory_detail` (
                                    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id作为主键',
                                    `inventory_id` BIGINT NOT NULL COMMENT '出入库表id',
                                    `material_category_id` BIGINT NOT NULL COMMENT '物料分类id',
                                    `material_spec_id` BIGINT DEFAULT NULL COMMENT '详细类型id',
                                    `material_quantity` int DEFAULT 0 COMMENT '盘扣数量'
                                     `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
                                    `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                                    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                    `update_by` varchar(64) DEFAULT '' COMMENT '更新人',
                                    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                    `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
                                    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='库存出入库明细表，记录具体没种盘扣类型的数量、重量和总重量等信息';

CREATE TABLE `inventory_fee` (
                                 `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id作为主键',
                                 `inventory_id` BIGINT NOT NULL COMMENT '出入库表id',
                                 `material_category_id` BIGINT NOT NULL COMMENT '物料分类id',
                                 `material_spec_id` BIGINT DEFAULT NULL COMMENT '详细类型id',
                                 `fee_id` BIGINT DEFAULT NULL COMMENT '杂费名称id',
                                 `received_count`  int DEFAULT 0 COMMENT '收货数量',
                                 `charged_count`  int DEFAULT 0 COMMENT '计费数量',
                                 `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
                                 `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                                 `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                 `update_by` varchar(64) DEFAULT '' COMMENT '更新人',
                                 `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                 `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
                                 PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='库存出入库明细表，记录具体没种盘扣类型的数量、重量和总重量等信息';

create table external_material(
	`id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id作为主键',
	`contract_id` bigint NOT NULL COMMENT '合同id',
	`material_category_id` BIGINT NOT NULL COMMENT '物料分类id',
    `material_spec_id` BIGINT DEFAULT NULL COMMENT '详细类型id',
	`single_weight` decimal(18,2) DEFAULT NULL COMMENT '单件重量，公斤',
	`supplier_id` bigint NOT NULL COMMENT '供应商id',`create_by` varchar(64) DEFAULT '' COMMENT '创建者',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_by` varchar(64) DEFAULT '' COMMENT '更新人',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
   PRIMARY KEY (`id`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='外部物料信息';


drop table if exists settle;
create table settle(
	`id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id作为主键',
	`contract_id` bigint NOT NULL COMMENT '合同id',
	`theoretical_in_total` decimal(18,2) NOT NULL default 0 COMMENT '理论入库(供应商/中成)',
	`theoretical_out_total` decimal(18,2) NOT NULL default 0 COMMENT '理论出库(供应商/中成)',
	`warehouse_in_total` decimal(18,2) NOT NULL default 0 COMMENT '仓库称重入库',
	`warehouse_out_total` decimal(18,2) NOT NULL default 0 COMMENT '仓库称重出库',
	`scene_in_total` decimal(18,2) NOT NULL default 0 COMMENT '场地称重入库',
	`scene_out_total` decimal(18,2) NOT NULL default 0 COMMENT '场地称重出库',
	`status` TINYINT default 0 COMMENT '0:未结算1:已结算2:已归档',
	`remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
	`create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
   PRIMARY KEY (`id`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='进度对账单';

drop table if exists settle_inventory;
create table settle_inventory(
	`id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id作为主键',
	`settle_id` bigint NOT NULL COMMENT '进度对账单id',
	`inventory_id` bigint NOT NULL COMMENT '出入库单id',
	`create_by` varchar(64) DEFAULT '' COMMENT '创建者',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_by` varchar(64) DEFAULT '' COMMENT '更新人',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
    PRIMARY KEY (`id`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='进度单出入库单关系表';

-- 2022-05-27
alter table inventory add column dept_id bigint comment '组织(部门)id';

update inventory set dept_id = '200';


