/*
 Navicat Premium Data Transfer

 Source Server         : 200.5
 Source Server Type    : MySQL
 Source Server Version : 80024
 Source Host           : 192.168.200.5:3306
 Source Schema         : scaffold

 Target Server Type    : MySQL
 Target Server Version : 80024
 File Encoding         : 65001

 Date: 04/03/2022 14:07:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- drop all table
DROP TABLE IF EXISTS `balance`;
DROP TABLE IF EXISTS `balance_detail`;
DROP TABLE IF EXISTS `balance_strategy`;
DROP TABLE IF EXISTS `business_org`;
DROP TABLE IF EXISTS `inventory`;
DROP TABLE IF EXISTS `inventory_detail`;
DROP TABLE IF EXISTS `lease_contracts`;
DROP TABLE IF EXISTS `lessee`;
DROP TABLE IF EXISTS `lessor`;
DROP TABLE IF EXISTS `lessor_on_market`;
DROP TABLE IF EXISTS `lessor_user_resource`;
DROP TABLE IF EXISTS `lessor_users`;
DROP TABLE IF EXISTS `lessor_users_role`;
DROP TABLE IF EXISTS `manufacturer`;
DROP TABLE IF EXISTS `material_category`;
DROP TABLE IF EXISTS `material_specs`;
DROP TABLE IF EXISTS `po_contracts`;
DROP TABLE IF EXISTS `projects`;
DROP TABLE IF EXISTS `purchase_order`;
DROP TABLE IF EXISTS `scg_organization`;
DROP TABLE IF EXISTS `warehouse`;
-- ----------------------------
-- Records of QRTZ_BLOB_TRIGGERS
-- ----------------------------
-- ----------------------------
-- Table structure for balance
-- ----------------------------

CREATE TABLE `balance` (
                           `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id作为主键',
                           `lessorUSC` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '甲方统一社会信用代码',
                           `period` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '结算月度期间，按合同定，比如每月26号到下个月25号',
                           `period_startdate` date DEFAULT NULL COMMENT '结算月度开始日期',
                           `period_enddate` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '结算月度结束日期',
                           `balance_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '结算单号，月度期间+合同号',
                           `contract_no` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '合同编号',
                           `total_weight` decimal(18,2) DEFAULT NULL COMMENT '盘扣总重量，公斤',
                           `material_fees` decimal(18,2) DEFAULT NULL COMMENT '盘扣总费用',
                           `freight` decimal(18,2) DEFAULT NULL COMMENT '运输费',
                           `repair_fee` decimal(18,2) DEFAULT NULL COMMENT '整修赔偿费',
                           `other_fee` decimal(18,2) DEFAULT NULL COMMENT '其它费用',
                           `period_new` decimal(18,2) DEFAULT NULL COMMENT '本月新增盘扣总重量',
                           `period_return` decimal(18,2) DEFAULT NULL COMMENT '本月退货盘扣总重量',
                           `period_stock` decimal(18,2) DEFAULT NULL COMMENT '本月新增退货后盘扣存量，用于下个月度的计费',
                           `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
                           `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                           `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                           `update_by` varchar(64) DEFAULT '' COMMENT '更新人',
                           `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                           `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='结算表';

-- ----------------------------
-- Records of balance
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for balance_detail
-- ----------------------------

CREATE TABLE `balance_detail` (
                                  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id作为主键',
                                  `balance_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '结算单号，月度期间+合同号',
                                  `material_spec` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '盘扣规格',
                                  `material_weight` decimal(18,2) DEFAULT NULL COMMENT '盘扣重量，吨',
                                  `unitprice` decimal(18,2) DEFAULT NULL COMMENT '租赁单价',
                                  `lease_startdate` datetime DEFAULT NULL COMMENT '结算开始日期',
                                  `lease_enddate` datetime DEFAULT NULL COMMENT '结算结束日期',
                                  `lease_days` int DEFAULT NULL COMMENT '租赁天数',
                                  `amount` decimal(18,2) DEFAULT NULL COMMENT '租赁总费用',
                                  `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='结算明细表';

-- ----------------------------
-- Records of balance_detail
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for balance_strategy
-- ----------------------------

CREATE TABLE `balance_strategy` (
                                    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id作为主键',
                                    `lessorUSC` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '甲方统一社会信用代码',
                                    `period` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '月度期间，每月21号到下个月20号',
                                    `balance_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '结算单号，月度期间+合同号',
                                    `material_spec` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '盘扣规格',
                                    `material_quantity` int DEFAULT NULL COMMENT '盘扣数量',
                                    `material_weight` decimal(15,3) DEFAULT NULL COMMENT '盘扣重量，吨',
                                    `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
                                    `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                                    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                    `update_by` varchar(64) DEFAULT '' COMMENT '更新人',
                                    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                    `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
                                    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='结算策略表，用于设定结算规则，比如收发货当天是否结算、运费、维修费等，是针对合同和项目的';

-- ----------------------------
-- Records of balance_strategy
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for business_org
-- ----------------------------

CREATE TABLE `business_org` (
                                `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id作为主键',
                                `hierarchy_code` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '层级码',
                                `parent_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '父级Id',
                                `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '全称',
                                `abbr_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '简称',
                                `level` int NOT NULL DEFAULT '0' COMMENT '1:一级,2:二级,3:三级,以此类推',
                                `status` int NOT NULL DEFAULT '0' COMMENT '0:正常,1:禁止',
                                `sort` int DEFAULT NULL COMMENT '从1开始',
                                `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
                                `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                                `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                `update_by` varchar(64) DEFAULT '' COMMENT '更新人',
                                `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='业务组织表，目前暂时没用，待租赁公司部门和下级单位有业务需求再扩充';

-- ----------------------------
-- Records of business_org
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for inventory
-- ----------------------------

CREATE TABLE `inventory` (
                             `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id作为主键',
                             `warehouseid` bigint NOT NULL,
                             `stock_inout_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '出入库单号，流水单号，自动生成',
                             `stock_direction` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '入库还是出库：0为入库，1为出库',
                             `stockin_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '入库类型',
                             `stockout_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '出库类型',
                             `stock_date` datetime DEFAULT NULL COMMENT '出入库日期',
                             `contract_no` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '合同号',
                             `contract_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '合同名称',
                             `freight` decimal(18,2) DEFAULT NULL COMMENT '运输费',
                             `transportation_unitprice` decimal(10,2) DEFAULT NULL COMMENT '运输单价，元、吨',
                             `loading_fee` decimal(18,2) DEFAULT NULL COMMENT '装车费',
                             `unloading_fee` decimal(18,2) DEFAULT NULL COMMENT '卸车费',
                             `transport_unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '运输单位',
                             `car_rental_fee` decimal(18,2) DEFAULT NULL COMMENT '运输车租赁费',
                             `car_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '车牌号',
                             `car_shift` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '车次，第一车、第二车.....是否有必要',
                             `origin` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '线路起点',
                             `destination` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '线路终点',
                             `lessor_theoretical_weight` decimal(18,2) DEFAULT NULL COMMENT '出租方理论重量，公斤，整车重量',
                             `supplier_theoretical_weight` decimal(18,2) DEFAULT NULL COMMENT '供应商理论重量，公斤，整车重量',
                             `warehouse_weight` decimal(18,2) DEFAULT NULL COMMENT '仓库称重',
                             `scene_weight` decimal(18,2) DEFAULT NULL COMMENT '场地称重',
                             `total_miscel_fee` decimal(18,2) DEFAULT NULL COMMENT '总杂费，元',
                             `driver` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '司机姓名',
                             `drivermobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '司机联系电话',
                             `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
                             `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                             `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                             `update_by` varchar(64) DEFAULT '' COMMENT '更新人',
                             `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                             `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='库存出入库总表';

-- ----------------------------
-- Records of inventory
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for inventory_detail
-- ----------------------------

CREATE TABLE `inventory_detail` (
                                    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id作为主键',
                                    `stock_inout_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '出入库单号，流水单号，自动生成',
                                    `material_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '盘扣名称',
                                    `material_spec` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '盘扣规格',
                                    `material_quantity` int DEFAULT NULL COMMENT '盘扣数量',
                                    `single_weight` decimal(18,2) DEFAULT NULL COMMENT '单件重量，公斤',
                                    `units` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '单位',
                                    `package_quantity` int DEFAULT NULL COMMENT '件数，打包数量',
                                    `total_weight` decimal(18,2) DEFAULT NULL COMMENT '盘扣总重量，公斤',
                                    `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
                                    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='库存出入库明细表，记录具体没种盘扣类型的数量、重量和总重量等信息';

-- ----------------------------
-- Records of inventory_detail
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for lease_contracts
-- ----------------------------

CREATE TABLE `lease_contracts` (
                                   `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id作为主键',
                                   `PONumber` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '需求单号，乙方发起的租赁需求',
                                   `contract_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '合同名称',
                                   `category` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '合同类别，包含出租、寄存、外借等',
                                   `contractNO` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '合同编号',
                                   `contract_date` datetime NOT NULL COMMENT '合同日期',
                                   `pro_code` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '项目编号，一般一个合同对应一个项目',
                                   `amount` decimal(14,2) NOT NULL COMMENT '合同金额',
                                   `begin_date` datetime NOT NULL COMMENT '合同开始时间',
                                   `end_date` datetime NOT NULL COMMENT '合同结束时间',
                                   `reconcile_startdate` datetime DEFAULT NULL COMMENT '每月对账开始日期，包含',
                                   `reconcile_enddate` datetime DEFAULT NULL COMMENT '每月对账结束日期，包含',
                                   `attachment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '附件，一般为合同扫描件上传后地址',
                                   `partyA_usc` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '合同甲方统一社会信用代码，即中成租赁或周转材料机构',
                                   `partyB_usc` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '合同乙方统一社会信用代码',
                                   `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
                                   `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                                   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                   `update_by` varchar(64) DEFAULT '' COMMENT '更新人',
                                   `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                   `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
                                   PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='租赁合同，包含出租、寄存、外借等';

-- ----------------------------
-- Records of lease_contracts
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for lessee
-- ----------------------------

CREATE TABLE `lessee` (
                          `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id作为主键',
                          `company_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '承租人公司名称',
                          `usc` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '统一社会信用代码',
                          `contactor` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '联系人',
                          `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '联系人电话',
                          `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '公司地址',
                          `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
                          `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                          `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                          `update_by` varchar(64) DEFAULT '' COMMENT '更新人',
                          `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                          `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='承租人，一般指与中成租赁签订盘扣租赁合同的乙方';

-- ----------------------------
-- Records of lessee
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for lessor
-- ----------------------------

CREATE TABLE `lessor` (
                          `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id作为主键',
                          `company_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '租赁公司名称',
                          `usc` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '统一社会信用代码',
                          `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '公司地址',
                          `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
                          `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                          `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                          `update_by` varchar(64) DEFAULT '' COMMENT '更新人',
                          `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                          `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='出租人，一般指中成租赁公司，以及其它子集团的周转材料管理机构等';

-- ----------------------------
-- Records of lessor
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for lessor_on_market
-- ----------------------------

CREATE TABLE `lessor_on_market` (
                                    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id作为主键',
                                    `rental_type` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '租赁类型（外键）',
                                    `units_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '单位名称',
                                    `units_address` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '单位地址',
                                    `units_status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '单位状态',
                                    `legal` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '法定代表人',
                                    `regist_funds` decimal(18,4) DEFAULT NULL COMMENT '注册资金(万元)',
                                    `contact` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '联系人',
                                    `contact_us` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '联系电话',
                                    `self_frog` decimal(18,3) DEFAULT NULL COMMENT '自有盘扣（吨）',
                                    `remarks` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
                                    `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                                    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                    `update_by` varchar(64) DEFAULT '' COMMENT '更新人',
                                    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                    `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
                                    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='外部租赁单位名录，指可以和中成等发生盘扣业务租赁外来的外部租赁公司';

-- ----------------------------
-- Records of lessor_on_market
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for lessor_user_resource
-- ----------------------------

CREATE TABLE `lessor_user_resource` (
                                        `id` bigint NOT NULL AUTO_INCREMENT,
                                        `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                        `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '资源名称',
                                        `url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '资源URL',
                                        `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '描述',
                                        `category_id` bigint DEFAULT NULL COMMENT '资源分类ID',
                                        PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='用户资源表，一般指url路径';

-- ----------------------------
-- Records of lessor_user_resource
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for lessor_users
-- ----------------------------

CREATE TABLE `lessor_users` (
                                `id` bigint NOT NULL AUTO_INCREMENT,
                                `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
                                `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
                                `org_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '管理组织id',
                                `icon` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '头像',
                                `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '邮箱',
                                `nick_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '昵称',
                                `note` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注信息',
                                `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                `login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
                                `status` int DEFAULT '1' COMMENT '帐号启用状态：0->禁用；1->启用',
                                `belongs_org_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所属组织id',
                                `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '手机号',
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='租赁公司用户表，目前主要是中成租赁的用户';

-- ----------------------------
-- Records of lessor_users
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for lessor_users_role
-- ----------------------------

CREATE TABLE `lessor_users_role` (
                                     `id` bigint NOT NULL AUTO_INCREMENT,
                                     `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '名称',
                                     `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '描述',
                                     `admin_count` int DEFAULT NULL COMMENT '后台用户数量',
                                     `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                     `status` int DEFAULT '1' COMMENT '启用状态：0->禁用；1->启用',
                                     `sort` int DEFAULT '0',
                                     PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='用户角色表';

-- ----------------------------
-- Records of lessor_users_role
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for manufacturer
-- ----------------------------

CREATE TABLE `manufacturer` (
                                `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id作为主键',
                                `units_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '单位名称',
                                `units_address` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '单位地址',
                                `legal` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '法人',
                                `regist_funds` decimal(18,4) NOT NULL COMMENT '注册资金（万元）',
                                `contact` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '联系人',
                                `contact_us` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '联系电话',
                                `remarks` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
                                `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                                `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                `update_by` varchar(64) DEFAULT '' COMMENT '更新人',
                                `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='生产商名录表';

-- ----------------------------
-- Records of manufacturer
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for material_category
-- ----------------------------

CREATE TABLE `material_category` (
                                     `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id作为主键',
                                     `code` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '编码',
                                     `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '名称',
                                     `m_unit` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '主计量单位',
                                     `a_unit` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '辅计量单位',
                                     `remarks` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
                                     `flag` int(1) unsigned zerofill DEFAULT '0' COMMENT '标记。0：其它，1:立杆，2：水平杆，3：脚手板',
                                     `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                                     `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                     `update_by` varchar(64) DEFAULT '' COMMENT '更新人',
                                     `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                     `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
                                     PRIMARY KEY (`id`) USING BTREE

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='物料分类表';

-- ----------------------------
-- Records of material_category
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for material_specs
-- ----------------------------

CREATE TABLE `material_specs` (
                                  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id作为主键',
                                  `category_code` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '分类编码',
                                  `specs_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '型号',
                                  `specs_type` int DEFAULT NULL COMMENT '规格类型。0：支撑架，1：作业架',
                                  `diameter` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '直径',
                                  `thickness` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '厚度',
                                  `lengths` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '长度',
                                  `material` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '材质',
                                  `units` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '单位',
                                  `single_weight` decimal(18,3) DEFAULT NULL COMMENT '单件重量',
                                  `packages_number` int DEFAULT NULL COMMENT '常见打包数量',
                                  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                                  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                  `update_by` varchar(64) DEFAULT '' COMMENT '更新人',
                                  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                  `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
                                  PRIMARY KEY (`id`) USING BTREE

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='物料规格表';

-- ----------------------------
-- Records of material_specs
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for po_contracts
-- ----------------------------

CREATE TABLE `po_contracts` (
                                `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id作为主键',
                                `PONumber` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '采购单号',
                                `contract_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '合同名称',
                                `category` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '合同类别，包含采购合同、出租合同、寄存、外借等',
                                `contractNO` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '合同编号',
                                `contract_date` datetime NOT NULL COMMENT '合同日期',
                                `amount` decimal(14,2) NOT NULL COMMENT '合同金额',
                                `begin_date` datetime NOT NULL COMMENT '合同开始时间',
                                `end_date` datetime NOT NULL COMMENT '合同结束时间',
                                `attachment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '附件，一般为合同扫描件上传后地址',
                                `partyA` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '合同甲方',
                                `partyB` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '合同乙方，即供应商',
                                `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
                                `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                                `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                `update_by` varchar(64) DEFAULT '' COMMENT '更新人',
                                `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='采购合同，一般由采购单(purchase order)转化而来';

-- ----------------------------
-- Records of po_contracts
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for projects
-- ----------------------------

CREATE TABLE `projects` (
                            `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id作为主键',
                            `pro_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '项目名称',
                            `pro_code` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '项目编号',
                            `pro_contract` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '合同编号',
                            `pro_address` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '项目地址',
                            `org_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '项目所属单位，集团的有值，外部项目为空',
                            `gateno` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '门号：2号门，用于送货地址',
                            `pro_state` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '项目状态',
                            `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                            `update_by` varchar(64) DEFAULT '' COMMENT '更新人',
                            `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                            `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='项目基本信息，不包含其他业务数据';

-- ----------------------------
-- Records of projects
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for purchase_order
-- ----------------------------

CREATE TABLE `purchase_order` (
                                  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id作为主键',
                                  `PONumber` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '采购单号',
                                  `lessorUSC` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '租赁公司统一社会信用代码',
                                  `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
                                  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                                  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                  `update_by` varchar(64) DEFAULT '' COMMENT '更新人',
                                  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                  `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='采购单';

-- ----------------------------
-- Records of purchase_order
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for scg_organization
-- ----------------------------

CREATE TABLE `scg_organization` (
                                    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id作为主键',
                                    `auth_code` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '组织权限码',
                                    `ext_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '外部Id',
                                    `parent_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '父级Id',
                                    `parent_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
                                    `code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
                                    `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '全称',
                                    `abbr_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '简称',
                                    `level` int DEFAULT '0' COMMENT '1:一级,2:二级,3:三级,以此类推',
                                    `status` int DEFAULT '0' COMMENT '0:正常,1:禁止',
                                    `sort` int DEFAULT '0' COMMENT '从1开始',
                                    `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
                                    `org_type` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '机构类型',
                                    `is_legal_unit` tinyint DEFAULT '0' COMMENT '是否法人单位',
                                    `is_virtual_org` tinyint DEFAULT '0' COMMENT '是否虚拟组织',
                                    `chief_rating_code` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '分级码（行政）',
                                    `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                                    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                    `update_by` varchar(64) DEFAULT '' COMMENT '更新人',
                                    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                    `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
                                    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='组织表，由主数据提供';

-- ----------------------------
-- Records of scg_organization
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for warehouse
-- ----------------------------

CREATE TABLE `warehouse` (
                             `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id作为主键',
                             `code` varchar(16) DEFAULT NULL COMMENT '仓库编码',
                             `dept_id` bigint NOT NULL COMMENT '组织id',
                             `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '仓库名称',
                             `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '仓库地址',
                             `keeper` varchar(10) DEFAULT NULL COMMENT '仓库管理员',
                             `remark` varchar(255) DEFAULT NULL COMMENT '备注',
                             `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                             `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                             `update_by` varchar(64) DEFAULT '' COMMENT '更新人',
                             `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                             `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='仓库表';

DROP TABLE IF EXISTS `rental_unit`;
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

DROP TABLE IF EXISTS `manufacturer`;
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


SET FOREIGN_KEY_CHECKS = 1;
