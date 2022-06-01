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

-- ----------------------------
-- Table structure for QRTZ_BLOB_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_BLOB_TRIGGERS`;
CREATE TABLE `QRTZ_BLOB_TRIGGERS` (
                                      `sched_name` varchar(120) NOT NULL COMMENT '调度名称',
                                      `trigger_name` varchar(200) NOT NULL COMMENT 'qrtz_triggers表trigger_name的外键',
                                      `trigger_group` varchar(200) NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
                                      `blob_data` blob COMMENT '存放持久化Trigger对象',
                                      PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
                                      CONSTRAINT `QRTZ_BLOB_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `QRTZ_TRIGGERS` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Blob类型的触发器表';

-- ----------------------------
-- Records of QRTZ_BLOB_TRIGGERS
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for QRTZ_CALENDARS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_CALENDARS`;
CREATE TABLE `QRTZ_CALENDARS` (
                                  `sched_name` varchar(120) NOT NULL COMMENT '调度名称',
                                  `calendar_name` varchar(200) NOT NULL COMMENT '日历名称',
                                  `calendar` blob NOT NULL COMMENT '存放持久化calendar对象',
                                  PRIMARY KEY (`sched_name`,`calendar_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='日历信息表';

-- ----------------------------
-- Records of QRTZ_CALENDARS
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for QRTZ_CRON_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_CRON_TRIGGERS`;
CREATE TABLE `QRTZ_CRON_TRIGGERS` (
                                      `sched_name` varchar(120) NOT NULL COMMENT '调度名称',
                                      `trigger_name` varchar(200) NOT NULL COMMENT 'qrtz_triggers表trigger_name的外键',
                                      `trigger_group` varchar(200) NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
                                      `cron_expression` varchar(200) NOT NULL COMMENT 'cron表达式',
                                      `time_zone_id` varchar(80) DEFAULT NULL COMMENT '时区',
                                      PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
                                      CONSTRAINT `QRTZ_CRON_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `QRTZ_TRIGGERS` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Cron类型的触发器表';

-- ----------------------------
-- Records of QRTZ_CRON_TRIGGERS
-- ----------------------------
BEGIN;
INSERT INTO `QRTZ_CRON_TRIGGERS` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME1', 'DEFAULT', '0/10 * * * * ?', 'Asia/Shanghai');
INSERT INTO `QRTZ_CRON_TRIGGERS` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME2', 'DEFAULT', '0/15 * * * * ?', 'Asia/Shanghai');
INSERT INTO `QRTZ_CRON_TRIGGERS` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME3', 'DEFAULT', '0/20 * * * * ?', 'Asia/Shanghai');
COMMIT;

-- ----------------------------
-- Table structure for QRTZ_FIRED_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_FIRED_TRIGGERS`;
CREATE TABLE `QRTZ_FIRED_TRIGGERS` (
                                       `sched_name` varchar(120) NOT NULL COMMENT '调度名称',
                                       `entry_id` varchar(95) NOT NULL COMMENT '调度器实例id',
                                       `trigger_name` varchar(200) NOT NULL COMMENT 'qrtz_triggers表trigger_name的外键',
                                       `trigger_group` varchar(200) NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
                                       `instance_name` varchar(200) NOT NULL COMMENT '调度器实例名',
                                       `fired_time` bigint NOT NULL COMMENT '触发的时间',
                                       `sched_time` bigint NOT NULL COMMENT '定时器制定的时间',
                                       `priority` int NOT NULL COMMENT '优先级',
                                       `state` varchar(16) NOT NULL COMMENT '状态',
                                       `job_name` varchar(200) DEFAULT NULL COMMENT '任务名称',
                                       `job_group` varchar(200) DEFAULT NULL COMMENT '任务组名',
                                       `is_nonconcurrent` varchar(1) DEFAULT NULL COMMENT '是否并发',
                                       `requests_recovery` varchar(1) DEFAULT NULL COMMENT '是否接受恢复执行',
                                       PRIMARY KEY (`sched_name`,`entry_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='已触发的触发器表';

-- ----------------------------
-- Records of QRTZ_FIRED_TRIGGERS
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for QRTZ_JOB_DETAILS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_JOB_DETAILS`;
CREATE TABLE `QRTZ_JOB_DETAILS` (
                                    `sched_name` varchar(120) NOT NULL COMMENT '调度名称',
                                    `job_name` varchar(200) NOT NULL COMMENT '任务名称',
                                    `job_group` varchar(200) NOT NULL COMMENT '任务组名',
                                    `description` varchar(250) DEFAULT NULL COMMENT '相关介绍',
                                    `job_class_name` varchar(250) NOT NULL COMMENT '执行任务类名称',
                                    `is_durable` varchar(1) NOT NULL COMMENT '是否持久化',
                                    `is_nonconcurrent` varchar(1) NOT NULL COMMENT '是否并发',
                                    `is_update_data` varchar(1) NOT NULL COMMENT '是否更新数据',
                                    `requests_recovery` varchar(1) NOT NULL COMMENT '是否接受恢复执行',
                                    `job_data` blob COMMENT '存放持久化job对象',
                                    PRIMARY KEY (`sched_name`,`job_name`,`job_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='任务详细信息表';

-- ----------------------------
-- Records of QRTZ_JOB_DETAILS
-- ----------------------------
BEGIN;
INSERT INTO `QRTZ_JOB_DETAILS` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME1', 'DEFAULT', NULL, 'com.ruoyi.quartz.util.QuartzDisallowConcurrentExecution', '0', '1', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000F5441534B5F50524F504552544945537372001E636F6D2E72756F79692E71756172747A2E646F6D61696E2E5379734A6F6200000000000000010200084C000A636F6E63757272656E747400124C6A6176612F6C616E672F537472696E673B4C000E63726F6E45787072657373696F6E71007E00094C000C696E766F6B6554617267657471007E00094C00086A6F6247726F757071007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C00076A6F624E616D6571007E00094C000D6D697366697265506F6C69637971007E00094C000673746174757371007E000978720027636F6D2E72756F79692E636F6D6D6F6E2E636F72652E646F6D61696E2E42617365456E7469747900000000000000010200074C0008637265617465427971007E00094C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C0006706172616D7371007E00034C000672656D61726B71007E00094C000B73656172636856616C756571007E00094C0008757064617465427971007E00094C000A75706461746554696D6571007E000C787074000561646D696E7372000E6A6176612E7574696C2E44617465686A81014B597419030000787077080000017F2E8BCFC878707400007070707400013174000E302F3130202A202A202A202A203F74001172795461736B2E72794E6F506172616D7374000744454641554C547372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000000000000001740018E7B3BBE7BB9FE9BB98E8AEA4EFBC88E697A0E58F82EFBC8974000133740001317800);
INSERT INTO `QRTZ_JOB_DETAILS` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME2', 'DEFAULT', NULL, 'com.ruoyi.quartz.util.QuartzDisallowConcurrentExecution', '0', '1', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000F5441534B5F50524F504552544945537372001E636F6D2E72756F79692E71756172747A2E646F6D61696E2E5379734A6F6200000000000000010200084C000A636F6E63757272656E747400124C6A6176612F6C616E672F537472696E673B4C000E63726F6E45787072657373696F6E71007E00094C000C696E766F6B6554617267657471007E00094C00086A6F6247726F757071007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C00076A6F624E616D6571007E00094C000D6D697366697265506F6C69637971007E00094C000673746174757371007E000978720027636F6D2E72756F79692E636F6D6D6F6E2E636F72652E646F6D61696E2E42617365456E7469747900000000000000010200074C0008637265617465427971007E00094C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C0006706172616D7371007E00034C000672656D61726B71007E00094C000B73656172636856616C756571007E00094C0008757064617465427971007E00094C000A75706461746554696D6571007E000C787074000561646D696E7372000E6A6176612E7574696C2E44617465686A81014B597419030000787077080000017F2E8BCFC878707400007070707400013174000E302F3135202A202A202A202A203F74001572795461736B2E7279506172616D7328277279272974000744454641554C547372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000000000000002740018E7B3BBE7BB9FE9BB98E8AEA4EFBC88E69C89E58F82EFBC8974000133740001317800);
INSERT INTO `QRTZ_JOB_DETAILS` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME3', 'DEFAULT', NULL, 'com.ruoyi.quartz.util.QuartzDisallowConcurrentExecution', '0', '1', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000F5441534B5F50524F504552544945537372001E636F6D2E72756F79692E71756172747A2E646F6D61696E2E5379734A6F6200000000000000010200084C000A636F6E63757272656E747400124C6A6176612F6C616E672F537472696E673B4C000E63726F6E45787072657373696F6E71007E00094C000C696E766F6B6554617267657471007E00094C00086A6F6247726F757071007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C00076A6F624E616D6571007E00094C000D6D697366697265506F6C69637971007E00094C000673746174757371007E000978720027636F6D2E72756F79692E636F6D6D6F6E2E636F72652E646F6D61696E2E42617365456E7469747900000000000000010200074C0008637265617465427971007E00094C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C0006706172616D7371007E00034C000672656D61726B71007E00094C000B73656172636856616C756571007E00094C0008757064617465427971007E00094C000A75706461746554696D6571007E000C787074000561646D696E7372000E6A6176612E7574696C2E44617465686A81014B597419030000787077080000017F2E8BCFC878707400007070707400013174000E302F3230202A202A202A202A203F74003872795461736B2E72794D756C7469706C65506172616D7328277279272C20747275652C20323030304C2C203331362E3530442C203130302974000744454641554C547372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000000000000003740018E7B3BBE7BB9FE9BB98E8AEA4EFBC88E5A49AE58F82EFBC8974000133740001317800);
COMMIT;

-- ----------------------------
-- Table structure for QRTZ_LOCKS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_LOCKS`;
CREATE TABLE `QRTZ_LOCKS` (
                              `sched_name` varchar(120) NOT NULL COMMENT '调度名称',
                              `lock_name` varchar(40) NOT NULL COMMENT '悲观锁名称',
                              PRIMARY KEY (`sched_name`,`lock_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='存储的悲观锁信息表';

-- ----------------------------
-- Records of QRTZ_LOCKS
-- ----------------------------
BEGIN;
INSERT INTO `QRTZ_LOCKS` VALUES ('RuoyiScheduler', 'STATE_ACCESS');
INSERT INTO `QRTZ_LOCKS` VALUES ('RuoyiScheduler', 'TRIGGER_ACCESS');
COMMIT;

-- ----------------------------
-- Table structure for QRTZ_PAUSED_TRIGGER_GRPS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_PAUSED_TRIGGER_GRPS`;
CREATE TABLE `QRTZ_PAUSED_TRIGGER_GRPS` (
                                            `sched_name` varchar(120) NOT NULL COMMENT '调度名称',
                                            `trigger_group` varchar(200) NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
                                            PRIMARY KEY (`sched_name`,`trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='暂停的触发器表';

-- ----------------------------
-- Records of QRTZ_PAUSED_TRIGGER_GRPS
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for QRTZ_SCHEDULER_STATE
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_SCHEDULER_STATE`;
CREATE TABLE `QRTZ_SCHEDULER_STATE` (
                                        `sched_name` varchar(120) NOT NULL COMMENT '调度名称',
                                        `instance_name` varchar(200) NOT NULL COMMENT '实例名称',
                                        `last_checkin_time` bigint NOT NULL COMMENT '上次检查时间',
                                        `checkin_interval` bigint NOT NULL COMMENT '检查间隔时间',
                                        PRIMARY KEY (`sched_name`,`instance_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='调度器状态表';

-- ----------------------------
-- Records of QRTZ_SCHEDULER_STATE
-- ----------------------------
BEGIN;
INSERT INTO `QRTZ_SCHEDULER_STATE` VALUES ('RuoyiScheduler', 'menmenMac.local1646301816844', 1646366319418, 15000);
COMMIT;

-- ----------------------------
-- Table structure for QRTZ_SIMPLE_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_SIMPLE_TRIGGERS`;
CREATE TABLE `QRTZ_SIMPLE_TRIGGERS` (
                                        `sched_name` varchar(120) NOT NULL COMMENT '调度名称',
                                        `trigger_name` varchar(200) NOT NULL COMMENT 'qrtz_triggers表trigger_name的外键',
                                        `trigger_group` varchar(200) NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
                                        `repeat_count` bigint NOT NULL COMMENT '重复的次数统计',
                                        `repeat_interval` bigint NOT NULL COMMENT '重复的间隔时间',
                                        `times_triggered` bigint NOT NULL COMMENT '已经触发的次数',
                                        PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
                                        CONSTRAINT `QRTZ_SIMPLE_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `QRTZ_TRIGGERS` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='简单触发器的信息表';

-- ----------------------------
-- Records of QRTZ_SIMPLE_TRIGGERS
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for QRTZ_SIMPROP_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_SIMPROP_TRIGGERS`;
CREATE TABLE `QRTZ_SIMPROP_TRIGGERS` (
                                         `sched_name` varchar(120) NOT NULL COMMENT '调度名称',
                                         `trigger_name` varchar(200) NOT NULL COMMENT 'qrtz_triggers表trigger_name的外键',
                                         `trigger_group` varchar(200) NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
                                         `str_prop_1` varchar(512) DEFAULT NULL COMMENT 'String类型的trigger的第一个参数',
                                         `str_prop_2` varchar(512) DEFAULT NULL COMMENT 'String类型的trigger的第二个参数',
                                         `str_prop_3` varchar(512) DEFAULT NULL COMMENT 'String类型的trigger的第三个参数',
                                         `int_prop_1` int DEFAULT NULL COMMENT 'int类型的trigger的第一个参数',
                                         `int_prop_2` int DEFAULT NULL COMMENT 'int类型的trigger的第二个参数',
                                         `long_prop_1` bigint DEFAULT NULL COMMENT 'long类型的trigger的第一个参数',
                                         `long_prop_2` bigint DEFAULT NULL COMMENT 'long类型的trigger的第二个参数',
                                         `dec_prop_1` decimal(13,4) DEFAULT NULL COMMENT 'decimal类型的trigger的第一个参数',
                                         `dec_prop_2` decimal(13,4) DEFAULT NULL COMMENT 'decimal类型的trigger的第二个参数',
                                         `bool_prop_1` varchar(1) DEFAULT NULL COMMENT 'Boolean类型的trigger的第一个参数',
                                         `bool_prop_2` varchar(1) DEFAULT NULL COMMENT 'Boolean类型的trigger的第二个参数',
                                         PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
                                         CONSTRAINT `QRTZ_SIMPROP_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `QRTZ_TRIGGERS` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='同步机制的行锁表';

-- ----------------------------
-- Records of QRTZ_SIMPROP_TRIGGERS
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for QRTZ_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_TRIGGERS`;
CREATE TABLE `QRTZ_TRIGGERS` (
                                 `sched_name` varchar(120) NOT NULL COMMENT '调度名称',
                                 `trigger_name` varchar(200) NOT NULL COMMENT '触发器的名字',
                                 `trigger_group` varchar(200) NOT NULL COMMENT '触发器所属组的名字',
                                 `job_name` varchar(200) NOT NULL COMMENT 'qrtz_job_details表job_name的外键',
                                 `job_group` varchar(200) NOT NULL COMMENT 'qrtz_job_details表job_group的外键',
                                 `description` varchar(250) DEFAULT NULL COMMENT '相关介绍',
                                 `next_fire_time` bigint DEFAULT NULL COMMENT '上一次触发时间（毫秒）',
                                 `prev_fire_time` bigint DEFAULT NULL COMMENT '下一次触发时间（默认为-1表示不触发）',
                                 `priority` int DEFAULT NULL COMMENT '优先级',
                                 `trigger_state` varchar(16) NOT NULL COMMENT '触发器状态',
                                 `trigger_type` varchar(8) NOT NULL COMMENT '触发器的类型',
                                 `start_time` bigint NOT NULL COMMENT '开始时间',
                                 `end_time` bigint DEFAULT NULL COMMENT '结束时间',
                                 `calendar_name` varchar(200) DEFAULT NULL COMMENT '日程表名称',
                                 `misfire_instr` smallint DEFAULT NULL COMMENT '补偿执行的策略',
                                 `job_data` blob COMMENT '存放持久化job对象',
                                 PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
                                 KEY `sched_name` (`sched_name`,`job_name`,`job_group`),
                                 CONSTRAINT `QRTZ_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `job_name`, `job_group`) REFERENCES `QRTZ_JOB_DETAILS` (`sched_name`, `job_name`, `job_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='触发器详细信息表';

-- ----------------------------
-- Records of QRTZ_TRIGGERS
-- ----------------------------
BEGIN;
INSERT INTO `QRTZ_TRIGGERS` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME1', 'DEFAULT', 'TASK_CLASS_NAME1', 'DEFAULT', NULL, 1646301820000, -1, 5, 'PAUSED', 'CRON', 1646301816000, 0, NULL, 2, '');
INSERT INTO `QRTZ_TRIGGERS` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME2', 'DEFAULT', 'TASK_CLASS_NAME2', 'DEFAULT', NULL, 1646301825000, -1, 5, 'PAUSED', 'CRON', 1646301817000, 0, NULL, 2, '');
INSERT INTO `QRTZ_TRIGGERS` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME3', 'DEFAULT', 'TASK_CLASS_NAME3', 'DEFAULT', NULL, 1646301820000, -1, 5, 'PAUSED', 'CRON', 1646301817000, 0, NULL, 2, '');
COMMIT;

-- ----------------------------
-- Table structure for balance
-- ----------------------------
DROP TABLE IF EXISTS `balance`;
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
                           `update_by` varchar(64) DEFAULT '' COMMENT '更新至',
                           `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                           `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
                           PRIMARY KEY (`id`) USING BTREE,
                           KEY `balance_no` (`balance_no`) USING BTREE,
                           KEY `fk_balance_lessorUSC` (`lessorUSC`) USING BTREE,
                           CONSTRAINT `fk_balance_lessorUSC` FOREIGN KEY (`lessorUSC`) REFERENCES `lessor` (`usc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='结算表';

-- ----------------------------
-- Records of balance
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for balance_detail
-- ----------------------------
DROP TABLE IF EXISTS `balance_detail`;
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
                                  PRIMARY KEY (`id`) USING BTREE,
                                  KEY `fk_balance_detail_balance_no` (`balance_no`) USING BTREE,
                                  CONSTRAINT `fk_balance_detail_balance_no` FOREIGN KEY (`balance_no`) REFERENCES `balance` (`balance_no`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='结算明细表';

-- ----------------------------
-- Records of balance_detail
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for balance_strategy
-- ----------------------------
DROP TABLE IF EXISTS `balance_strategy`;
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
                                    `update_by` varchar(64) DEFAULT '' COMMENT '更新至',
                                    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                    `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
                                    PRIMARY KEY (`id`) USING BTREE,
                                    KEY `balance_no` (`balance_no`) USING BTREE,
                                    KEY `fk_balance_lessorUSC` (`lessorUSC`) USING BTREE,
                                    CONSTRAINT `balance_strategy_ibfk_1` FOREIGN KEY (`lessorUSC`) REFERENCES `lessor` (`usc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='结算策略表，用于设定结算规则，比如收发货当天是否结算、运费、维修费等，是针对合同和项目的';

-- ----------------------------
-- Records of balance_strategy
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for business_org
-- ----------------------------
DROP TABLE IF EXISTS `business_org`;
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
                                `update_by` varchar(64) DEFAULT '' COMMENT '更新至',
                                `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
                                PRIMARY KEY (`id`) USING BTREE,
                                KEY `hierarchy_code` (`hierarchy_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='业务组织表，目前暂时没用，待租赁公司部门和下级单位有业务需求再扩充';

-- ----------------------------
-- Records of business_org
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for gen_table
-- ----------------------------
DROP TABLE IF EXISTS `gen_table`;
CREATE TABLE `gen_table` (
                             `table_id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
                             `table_name` varchar(200) DEFAULT '' COMMENT '表名称',
                             `table_comment` varchar(500) DEFAULT '' COMMENT '表描述',
                             `sub_table_name` varchar(64) DEFAULT NULL COMMENT '关联子表的表名',
                             `sub_table_fk_name` varchar(64) DEFAULT NULL COMMENT '子表关联的外键名',
                             `class_name` varchar(100) DEFAULT '' COMMENT '实体类名称',
                             `tpl_category` varchar(200) DEFAULT 'crud' COMMENT '使用的模板（crud单表操作 tree树表操作）',
                             `package_name` varchar(100) DEFAULT NULL COMMENT '生成包路径',
                             `module_name` varchar(30) DEFAULT NULL COMMENT '生成模块名',
                             `business_name` varchar(30) DEFAULT NULL COMMENT '生成业务名',
                             `function_name` varchar(50) DEFAULT NULL COMMENT '生成功能名',
                             `function_author` varchar(50) DEFAULT NULL COMMENT '生成功能作者',
                             `gen_type` char(1) DEFAULT '0' COMMENT '生成代码方式（0zip压缩包 1自定义路径）',
                             `gen_path` varchar(200) DEFAULT '/' COMMENT '生成路径（不填默认项目路径）',
                             `options` varchar(1000) DEFAULT NULL COMMENT '其它生成选项',
                             `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                             `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                             `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
                             `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                             `remark` varchar(500) DEFAULT NULL COMMENT '备注',
                             PRIMARY KEY (`table_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='代码生成业务表';

-- ----------------------------
-- Records of gen_table
-- ----------------------------
BEGIN;
INSERT INTO `gen_table` VALUES (1, 'inventory', '库存出入库总表', 'inventory_detail', 'stock_inout_no', 'Inventory', 'sub', 'com.ruoyi.system', 'system', 'inventory', '库存出入库总', 'ruoyi', '1', '/', '{}', 'admin', '2022-02-28 14:53:32', '', '2022-02-28 15:53:17', NULL);
INSERT INTO `gen_table` VALUES (2, 'inventory_detail', '库存出入库明细表，记录具体没种盘扣类型的数量、重量和总重量等信息', NULL, NULL, 'InventoryDetail', 'crud', 'com.ruoyi.system', 'system', 'detail', '库存出入库明细，记录具体没种盘扣类型的数量、重量和总重量等信息', 'ruoyi', '0', '/', NULL, 'admin', '2022-02-28 14:53:33', '', NULL, NULL);
INSERT INTO `gen_table` VALUES (3, 'warehouse', '仓库表，一个租赁公司可以有多个仓库', NULL, NULL, 'Warehouse', 'crud', 'com.ruoyi.business', 'business', 'warehouse', '仓库管理', 'ruoyi', '1', '/Users/zhapeng/Documents/GitHub/RuoYi-Vue/', '{\"parentMenuId\":2019}', 'admin', '2022-03-03 14:53:10', '', '2022-03-03 15:23:43', NULL);
INSERT INTO `gen_table` VALUES (6, 'lessee', '承租人，一般指与中成租赁签订盘扣租赁合同的乙方', NULL, NULL, 'Lessee', 'crud', 'com.ruoyi.business', 'business', 'lessee', '承租人，一般指与中成租赁签订盘扣租赁合同的乙方', 'ruoyi', '0', '/', NULL, 'admin', '2022-03-04 10:56:47', '', NULL, NULL);
INSERT INTO `gen_table` VALUES (7, 'lessor', '出租人，一般指中成租赁公司，以及其它子集团的周转材料管理机构等', NULL, NULL, 'Lessor', 'crud', 'com.ruoyi.business', 'business', 'lessor', '出租人，一般指中成租赁公司，以及其它子集团的周转材料管理机构等', 'ruoyi', '0', '/', NULL, 'admin', '2022-03-04 10:56:47', '', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for gen_table_column
-- ----------------------------
DROP TABLE IF EXISTS `gen_table_column`;
CREATE TABLE `gen_table_column` (
                                    `column_id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
                                    `table_id` varchar(64) DEFAULT NULL COMMENT '归属表编号',
                                    `column_name` varchar(200) DEFAULT NULL COMMENT '列名称',
                                    `column_comment` varchar(500) DEFAULT NULL COMMENT '列描述',
                                    `column_type` varchar(100) DEFAULT NULL COMMENT '列类型',
                                    `java_type` varchar(500) DEFAULT NULL COMMENT 'JAVA类型',
                                    `java_field` varchar(200) DEFAULT NULL COMMENT 'JAVA字段名',
                                    `is_pk` char(1) DEFAULT NULL COMMENT '是否主键（1是）',
                                    `is_increment` char(1) DEFAULT NULL COMMENT '是否自增（1是）',
                                    `is_required` char(1) DEFAULT NULL COMMENT '是否必填（1是）',
                                    `is_insert` char(1) DEFAULT NULL COMMENT '是否为插入字段（1是）',
                                    `is_edit` char(1) DEFAULT NULL COMMENT '是否编辑字段（1是）',
                                    `is_list` char(1) DEFAULT NULL COMMENT '是否列表字段（1是）',
                                    `is_query` char(1) DEFAULT NULL COMMENT '是否查询字段（1是）',
                                    `query_type` varchar(200) DEFAULT 'EQ' COMMENT '查询方式（等于、不等于、大于、小于、范围）',
                                    `html_type` varchar(200) DEFAULT NULL COMMENT '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
                                    `dict_type` varchar(200) DEFAULT '' COMMENT '字典类型',
                                    `sort` int DEFAULT NULL COMMENT '排序',
                                    `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                                    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                    `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
                                    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                    PRIMARY KEY (`column_id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='代码生成业务表字段';

-- ----------------------------
-- Records of gen_table_column
-- ----------------------------
BEGIN;
INSERT INTO `gen_table_column` VALUES (1, '1', 'id', 'Guid作为主键', 'varchar(36)', 'String', 'id', '1', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', NULL, 1, 'admin', '2022-02-28 14:53:32', NULL, '2022-02-28 15:53:17');
INSERT INTO `gen_table_column` VALUES (2, '1', 'warehouseid', '', 'varchar(36)', 'String', 'warehouseid', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2022-02-28 14:53:32', NULL, '2022-02-28 15:53:18');
INSERT INTO `gen_table_column` VALUES (3, '1', 'stock_inout_no', '出入库单号，流水单号，自动生成', 'varchar(20)', 'String', 'stockInoutNo', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2022-02-28 14:53:32', NULL, '2022-02-28 15:53:18');
INSERT INTO `gen_table_column` VALUES (4, '1', 'stock_direction', '入库还是出库：0为入库，1为出库', 'char(2)', 'String', 'stockDirection', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2022-02-28 14:53:32', NULL, '2022-02-28 15:53:18');
INSERT INTO `gen_table_column` VALUES (5, '1', 'stockin_type', '入库类型', 'varchar(10)', 'String', 'stockinType', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'select', '', 5, 'admin', '2022-02-28 14:53:33', NULL, '2022-02-28 15:53:18');
INSERT INTO `gen_table_column` VALUES (6, '1', 'stockout_type', '出库类型', 'varchar(10)', 'String', 'stockoutType', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'select', '', 6, 'admin', '2022-02-28 14:53:33', NULL, '2022-02-28 15:53:18');
INSERT INTO `gen_table_column` VALUES (7, '1', 'stock_date', '出入库日期', 'datetime', 'Date', 'stockDate', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 7, 'admin', '2022-02-28 14:53:33', NULL, '2022-02-28 15:53:18');
INSERT INTO `gen_table_column` VALUES (8, '1', 'contract_no', '合同号', 'varchar(120)', 'String', 'contractNo', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 8, 'admin', '2022-02-28 14:53:33', NULL, '2022-02-28 15:53:18');
INSERT INTO `gen_table_column` VALUES (9, '1', 'contract_name', '合同名称', 'varchar(255)', 'String', 'contractName', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 9, 'admin', '2022-02-28 14:53:33', NULL, '2022-02-28 15:53:18');
INSERT INTO `gen_table_column` VALUES (10, '1', 'freight', '运输费', 'decimal(18,2)', 'BigDecimal', 'freight', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 10, 'admin', '2022-02-28 14:53:33', NULL, '2022-02-28 15:53:18');
INSERT INTO `gen_table_column` VALUES (11, '1', 'transportation_unitprice', '运输单价，元、吨', 'decimal(10,2)', 'BigDecimal', 'transportationUnitprice', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 11, 'admin', '2022-02-28 14:53:33', NULL, '2022-02-28 15:53:18');
INSERT INTO `gen_table_column` VALUES (12, '1', 'loading_fee', '装车费', 'decimal(18,2)', 'BigDecimal', 'loadingFee', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 12, 'admin', '2022-02-28 14:53:33', NULL, '2022-02-28 15:53:18');
INSERT INTO `gen_table_column` VALUES (13, '1', 'unloading_fee', '卸车费', 'decimal(18,2)', 'BigDecimal', 'unloadingFee', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 13, 'admin', '2022-02-28 14:53:33', NULL, '2022-02-28 15:53:18');
INSERT INTO `gen_table_column` VALUES (14, '1', 'transport_unit', '运输单位', 'varchar(255)', 'String', 'transportUnit', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 14, 'admin', '2022-02-28 14:53:33', NULL, '2022-02-28 15:53:18');
INSERT INTO `gen_table_column` VALUES (15, '1', 'car_rental_fee', '运输车租赁费', 'decimal(18,2)', 'BigDecimal', 'carRentalFee', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 15, 'admin', '2022-02-28 14:53:33', NULL, '2022-02-28 15:53:18');
INSERT INTO `gen_table_column` VALUES (16, '1', 'car_number', '车牌号', 'varchar(20)', 'String', 'carNumber', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 16, 'admin', '2022-02-28 14:53:33', NULL, '2022-02-28 15:53:18');
INSERT INTO `gen_table_column` VALUES (17, '1', 'car_shift', '车次，第一车、第二车.....是否有必要', 'varchar(20)', 'String', 'carShift', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 17, 'admin', '2022-02-28 14:53:33', NULL, '2022-02-28 15:53:18');
INSERT INTO `gen_table_column` VALUES (20, '1', 'lessor_theoretical_weight', '出租方理论重量，公斤，整车重量', 'decimal(18,2)', 'BigDecimal', 'lessorTheoreticalWeight', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 20, 'admin', '2022-02-28 14:53:33', NULL, '2022-02-28 15:53:18');
INSERT INTO `gen_table_column` VALUES (21, '1', 'supplier_theoretical_weight', '供应商理论重量，公斤，整车重量', 'decimal(18,2)', 'BigDecimal', 'supplierTheoreticalWeight', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 21, 'admin', '2022-02-28 14:53:33', NULL, '2022-02-28 15:53:18');
INSERT INTO `gen_table_column` VALUES (22, '1', 'warehouse_weight', '仓库称重', 'decimal(18,2)', 'BigDecimal', 'warehouseWeight', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 22, 'admin', '2022-02-28 14:53:33', NULL, '2022-02-28 15:53:18');
INSERT INTO `gen_table_column` VALUES (23, '1', 'scene_weight', '场地称重', 'decimal(18,2)', 'BigDecimal', 'sceneWeight', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 23, 'admin', '2022-02-28 14:53:33', NULL, '2022-02-28 15:53:18');
INSERT INTO `gen_table_column` VALUES (24, '1', 'total_miscel_fee', '总杂费，元', 'decimal(18,2)', 'BigDecimal', 'totalMiscelFee', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 24, 'admin', '2022-02-28 14:53:33', NULL, '2022-02-28 15:53:18');
INSERT INTO `gen_table_column` VALUES (25, '1', 'driver', '司机姓名', 'varchar(20)', 'String', 'driver', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 25, 'admin', '2022-02-28 14:53:33', NULL, '2022-02-28 15:53:18');
INSERT INTO `gen_table_column` VALUES (26, '1', 'drivermobile', '司机联系电话', 'varchar(20)', 'String', 'drivermobile', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 26, 'admin', '2022-02-28 14:53:33', NULL, '2022-02-28 15:53:18');
INSERT INTO `gen_table_column` VALUES (27, '1', 'remark', '', 'varchar(100)', 'String', 'remark', '0', '0', NULL, '1', '1', '1', NULL, 'EQ', 'input', '', 27, 'admin', '2022-02-28 14:53:33', NULL, '2022-02-28 15:53:18');
INSERT INTO `gen_table_column` VALUES (28, '1', 'created_on', '', 'datetime(3)', 'Date', 'createdOn', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 28, 'admin', '2022-02-28 14:53:33', NULL, '2022-02-28 15:53:18');
INSERT INTO `gen_table_column` VALUES (29, '1', 'created_by', '', 'varchar(36)', 'String', 'createdBy', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 29, 'admin', '2022-02-28 14:53:33', NULL, '2022-02-28 15:53:18');
INSERT INTO `gen_table_column` VALUES (30, '1', 'modified_on', '', 'datetime(3)', 'Date', 'modifiedOn', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 30, 'admin', '2022-02-28 14:53:33', NULL, '2022-02-28 15:53:18');
INSERT INTO `gen_table_column` VALUES (31, '1', 'modified_by', '', 'varchar(36)', 'String', 'modifiedBy', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 31, 'admin', '2022-02-28 14:53:33', NULL, '2022-02-28 15:53:18');
INSERT INTO `gen_table_column` VALUES (32, '1', 'is_deleted', '是否删除0:未删除;1:删除', 'tinyint', 'Long', 'isDeleted', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 32, 'admin', '2022-02-28 14:53:33', NULL, '2022-02-28 15:53:18');
INSERT INTO `gen_table_column` VALUES (33, '2', 'id', 'Guid作为主键', 'varchar(36)', 'String', 'id', '1', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2022-02-28 14:53:33', '', NULL);
INSERT INTO `gen_table_column` VALUES (34, '2', 'stock_inout_no', '出入库单号，流水单号，自动生成', 'varchar(20)', 'String', 'stockInoutNo', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2022-02-28 14:53:33', '', NULL);
INSERT INTO `gen_table_column` VALUES (35, '2', 'material_name', '盘扣名称', 'varchar(255)', 'String', 'materialName', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 3, 'admin', '2022-02-28 14:53:33', '', NULL);
INSERT INTO `gen_table_column` VALUES (36, '2', 'material_spec', '盘扣规格', 'varchar(255)', 'String', 'materialSpec', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2022-02-28 14:53:33', '', NULL);
INSERT INTO `gen_table_column` VALUES (37, '2', 'material_quantity', '盘扣数量', 'int', 'Long', 'materialQuantity', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2022-02-28 14:53:33', '', NULL);
INSERT INTO `gen_table_column` VALUES (38, '2', 'single_weight', '单件重量，公斤', 'decimal(18,2)', 'BigDecimal', 'singleWeight', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2022-02-28 14:53:33', '', NULL);
INSERT INTO `gen_table_column` VALUES (39, '2', 'units', '单位', 'varchar(20)', 'String', 'units', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 7, 'admin', '2022-02-28 14:53:33', '', NULL);
INSERT INTO `gen_table_column` VALUES (40, '2', 'package_quantity', '件数，打包数量', 'int', 'Long', 'packageQuantity', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 8, 'admin', '2022-02-28 14:53:33', '', NULL);
INSERT INTO `gen_table_column` VALUES (41, '2', 'total_weight', '盘扣总重量，公斤', 'decimal(18,2)', 'BigDecimal', 'totalWeight', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 9, 'admin', '2022-02-28 14:53:33', '', NULL);
INSERT INTO `gen_table_column` VALUES (42, '2', 'remark', NULL, 'varchar(100)', 'String', 'remark', '0', '0', NULL, '1', '1', '1', NULL, 'EQ', 'input', '', 10, 'admin', '2022-02-28 14:53:33', '', NULL);
INSERT INTO `gen_table_column` VALUES (43, '1', 'origin', '线路起点', 'varchar(255)', 'String', 'origin', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 18, '', '2022-02-28 15:44:53', '', '2022-02-28 15:53:18');
INSERT INTO `gen_table_column` VALUES (44, '1', 'destination', '线路终点', 'varchar(255)', 'String', 'destination', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 19, '', '2022-02-28 15:44:53', '', '2022-02-28 15:53:18');
INSERT INTO `gen_table_column` VALUES (45, '3', 'id', NULL, 'varchar(36)', 'String', 'id', '1', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2022-03-03 14:53:10', '', '2022-03-03 15:23:43');
INSERT INTO `gen_table_column` VALUES (46, '3', 'lessorUSC', '租赁公司统一社会信用代码', 'varchar(18)', 'String', 'lessorusc', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2022-03-03 14:53:10', '', '2022-03-03 15:23:43');
INSERT INTO `gen_table_column` VALUES (47, '3', 'name', '仓库名称', 'varchar(255)', 'String', 'name', '0', '0', '1', '1', '1', '1', '1', 'LIKE', 'input', '', 3, 'admin', '2022-03-03 14:53:10', '', '2022-03-03 15:23:43');
INSERT INTO `gen_table_column` VALUES (48, '3', 'Address', '仓库地址', 'varchar(255)', 'String', 'address', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2022-03-03 14:53:10', '', '2022-03-03 15:23:43');
INSERT INTO `gen_table_column` VALUES (49, '3', 'created_on', NULL, 'datetime', 'Date', 'createdOn', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 5, 'admin', '2022-03-03 14:53:10', '', '2022-03-03 15:23:43');
INSERT INTO `gen_table_column` VALUES (50, '3', 'created_by', NULL, 'bigint', 'Long', 'createdBy', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2022-03-03 14:53:10', '', '2022-03-03 15:23:43');
INSERT INTO `gen_table_column` VALUES (51, '3', 'modified_on', NULL, 'datetime', 'Date', 'modifiedOn', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 7, 'admin', '2022-03-03 14:53:10', '', '2022-03-03 15:23:43');
INSERT INTO `gen_table_column` VALUES (52, '3', 'modified_by', NULL, 'bigint', 'Long', 'modifiedBy', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 8, 'admin', '2022-03-03 14:53:10', '', '2022-03-03 15:23:43');
INSERT INTO `gen_table_column` VALUES (53, '3', 'created_name', NULL, 'varchar(30)', 'String', 'createdName', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 9, 'admin', '2022-03-03 14:53:10', '', '2022-03-03 15:23:43');
INSERT INTO `gen_table_column` VALUES (54, '3', 'modified_name', NULL, 'varchar(30)', 'String', 'modifiedName', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 10, 'admin', '2022-03-03 14:53:10', '', '2022-03-03 15:23:43');
INSERT INTO `gen_table_column` VALUES (55, '3', 'is_deleted', NULL, 'char(1)', 'String', 'isDeleted', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 11, 'admin', '2022-03-03 14:53:10', '', '2022-03-03 15:23:43');
INSERT INTO `gen_table_column` VALUES (56, '3', 'keeper', '仓库管理员', 'varchar(10)', 'String', 'keeper', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 12, 'admin', '2022-03-03 14:53:10', '', '2022-03-03 15:23:43');
INSERT INTO `gen_table_column` VALUES (57, '3', 'remark', '备注', 'varchar(255)', 'String', 'remark', '0', '0', NULL, '1', '1', '1', NULL, 'EQ', 'input', '', 13, 'admin', '2022-03-03 14:53:10', '', '2022-03-03 15:23:43');
INSERT INTO `gen_table_column` VALUES (82, '6', 'id', 'Guid作为主键', 'varchar(36)', 'String', 'id', '1', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2022-03-04 10:56:47', '', NULL);
INSERT INTO `gen_table_column` VALUES (83, '6', 'company_name', '承租人公司名称', 'varchar(255)', 'String', 'companyName', '0', '0', '1', '1', '1', '1', '1', 'LIKE', 'input', '', 2, 'admin', '2022-03-04 10:56:47', '', NULL);
INSERT INTO `gen_table_column` VALUES (84, '6', 'usc', '统一社会信用代码', 'varchar(18)', 'String', 'usc', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2022-03-04 10:56:47', '', NULL);
INSERT INTO `gen_table_column` VALUES (85, '6', 'contactor', '联系人', 'varchar(20)', 'String', 'contactor', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2022-03-04 10:56:47', '', NULL);
INSERT INTO `gen_table_column` VALUES (86, '6', 'mobile', '联系人电话', 'varchar(20)', 'String', 'mobile', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2022-03-04 10:56:47', '', NULL);
INSERT INTO `gen_table_column` VALUES (87, '6', 'address', '公司地址', 'varchar(255)', 'String', 'address', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2022-03-04 10:56:47', '', NULL);
INSERT INTO `gen_table_column` VALUES (88, '6', 'remark', NULL, 'varchar(100)', 'String', 'remark', '0', '0', NULL, '1', '1', '1', NULL, 'EQ', 'input', '', 7, 'admin', '2022-03-04 10:56:47', '', NULL);
INSERT INTO `gen_table_column` VALUES (89, '6', 'created_on', NULL, 'datetime(3)', 'Date', 'createdOn', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 8, 'admin', '2022-03-04 10:56:47', '', NULL);
INSERT INTO `gen_table_column` VALUES (90, '6', 'created_by', NULL, 'varchar(36)', 'String', 'createdBy', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 9, 'admin', '2022-03-04 10:56:47', '', NULL);
INSERT INTO `gen_table_column` VALUES (91, '6', 'modified_on', NULL, 'datetime(3)', 'Date', 'modifiedOn', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 10, 'admin', '2022-03-04 10:56:47', '', NULL);
INSERT INTO `gen_table_column` VALUES (92, '6', 'modified_by', NULL, 'varchar(36)', 'String', 'modifiedBy', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 11, 'admin', '2022-03-04 10:56:47', '', NULL);
INSERT INTO `gen_table_column` VALUES (93, '6', 'is_deleted', '是否删除0:未删除;1:删除', 'tinyint', 'Long', 'isDeleted', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 12, 'admin', '2022-03-04 10:56:47', '', NULL);
INSERT INTO `gen_table_column` VALUES (94, '7', 'id', 'Guid作为主键', 'varchar(36)', 'String', 'id', '1', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2022-03-04 10:56:47', '', NULL);
INSERT INTO `gen_table_column` VALUES (95, '7', 'company_name', '租赁公司名称', 'varchar(255)', 'String', 'companyName', '0', '0', '1', '1', '1', '1', '1', 'LIKE', 'input', '', 2, 'admin', '2022-03-04 10:56:47', '', NULL);
INSERT INTO `gen_table_column` VALUES (96, '7', 'usc', '统一社会信用代码', 'varchar(18)', 'String', 'usc', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2022-03-04 10:56:47', '', NULL);
INSERT INTO `gen_table_column` VALUES (97, '7', 'address', '公司地址', 'varchar(255)', 'String', 'address', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2022-03-04 10:56:47', '', NULL);
INSERT INTO `gen_table_column` VALUES (98, '7', 'remark', NULL, 'varchar(100)', 'String', 'remark', '0', '0', NULL, '1', '1', '1', NULL, 'EQ', 'input', '', 5, 'admin', '2022-03-04 10:56:47', '', NULL);
INSERT INTO `gen_table_column` VALUES (99, '7', 'created_on', NULL, 'datetime(3)', 'Date', 'createdOn', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 6, 'admin', '2022-03-04 10:56:47', '', NULL);
INSERT INTO `gen_table_column` VALUES (100, '7', 'created_by', NULL, 'varchar(36)', 'String', 'createdBy', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 7, 'admin', '2022-03-04 10:56:47', '', NULL);
INSERT INTO `gen_table_column` VALUES (101, '7', 'modified_on', NULL, 'datetime(3)', 'Date', 'modifiedOn', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'datetime', '', 8, 'admin', '2022-03-04 10:56:47', '', NULL);
INSERT INTO `gen_table_column` VALUES (102, '7', 'modified_by', NULL, 'varchar(36)', 'String', 'modifiedBy', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 9, 'admin', '2022-03-04 10:56:47', '', NULL);
INSERT INTO `gen_table_column` VALUES (103, '7', 'is_deleted', '是否删除0:未删除;1:删除', 'tinyint', 'Long', 'isDeleted', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 10, 'admin', '2022-03-04 10:56:47', '', NULL);
COMMIT;

-- ----------------------------
-- Table structure for inventory
-- ----------------------------
DROP TABLE IF EXISTS `inventory`;
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
                             `update_by` varchar(64) DEFAULT '' COMMENT '更新至',
                             `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                             `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
                             PRIMARY KEY (`id`) USING BTREE,
                             KEY `fk_warehouseid` (`warehouseid`) USING BTREE,
                             CONSTRAINT `fk_warehouseid` FOREIGN KEY (`warehouseid`) REFERENCES `warehouse` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='库存出入库总表';

-- ----------------------------
-- Records of inventory
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for inventory_detail
-- ----------------------------
DROP TABLE IF EXISTS `inventory_detail`;
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
DROP TABLE IF EXISTS `lease_contracts`;
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
                                   `update_by` varchar(64) DEFAULT '' COMMENT '更新至',
                                   `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                   `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
                                   PRIMARY KEY (`id`) USING BTREE,
                                   KEY `contractNO` (`contractNO`) USING BTREE,
                                   KEY `fk_partyA_usc` (`partyA_usc`) USING BTREE,
                                   KEY `fk_partyB_usc` (`partyB_usc`) USING BTREE,
                                   KEY `fk_lease_contracts_pro_code` (`pro_code`) USING BTREE,
                                   CONSTRAINT `fk_lease_contracts_pro_code` FOREIGN KEY (`pro_code`) REFERENCES `projects` (`pro_code`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                                   CONSTRAINT `fk_partyA_usc` FOREIGN KEY (`partyA_usc`) REFERENCES `lessor` (`usc`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                                   CONSTRAINT `fk_partyB_usc` FOREIGN KEY (`partyB_usc`) REFERENCES `lessee` (`usc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='租赁合同，包含出租、寄存、外借等';

-- ----------------------------
-- Records of lease_contracts
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for lessee
-- ----------------------------
DROP TABLE IF EXISTS `lessee`;
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
                          `update_by` varchar(64) DEFAULT '' COMMENT '更新至',
                          `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                          `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
                          PRIMARY KEY (`id`) USING BTREE,
                          KEY `lesseeusc` (`usc`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='承租人，一般指与中成租赁签订盘扣租赁合同的乙方';

-- ----------------------------
-- Records of lessee
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for lessor
-- ----------------------------
DROP TABLE IF EXISTS `lessor`;
CREATE TABLE `lessor` (
                          `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id作为主键',
                          `company_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '租赁公司名称',
                          `usc` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '统一社会信用代码',
                          `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '公司地址',
                          `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
                          `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                          `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                          `update_by` varchar(64) DEFAULT '' COMMENT '更新至',
                          `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                          `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
                          PRIMARY KEY (`id`) USING BTREE,
                          KEY `lessorusc` (`usc`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='出租人，一般指中成租赁公司，以及其它子集团的周转材料管理机构等';

-- ----------------------------
-- Records of lessor
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for lessor_on_market
-- ----------------------------
DROP TABLE IF EXISTS `lessor_on_market`;
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
                                    `update_by` varchar(64) DEFAULT '' COMMENT '更新至',
                                    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                    `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
                                    PRIMARY KEY (`id`) USING BTREE,
                                    KEY `rental_type` (`rental_type`) USING BTREE,
                                    KEY `is_deleted` (`is_deleted`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='外部租赁单位名录，指可以和中成等发生盘扣业务租赁外来的外部租赁公司';

-- ----------------------------
-- Records of lessor_on_market
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for lessor_user_resource
-- ----------------------------
DROP TABLE IF EXISTS `lessor_user_resource`;
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
DROP TABLE IF EXISTS `lessor_users`;
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
DROP TABLE IF EXISTS `lessor_users_role`;
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
DROP TABLE IF EXISTS `manufacturer`;
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
                                `update_by` varchar(64) DEFAULT '' COMMENT '更新至',
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
DROP TABLE IF EXISTS `material_category`;
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
                                     `update_by` varchar(64) DEFAULT '' COMMENT '更新至',
                                     `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                     `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
                                     PRIMARY KEY (`id`) USING BTREE,
                                     UNIQUE KEY `code` (`code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='物料分类表';

-- ----------------------------
-- Records of material_category
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for material_specs
-- ----------------------------
DROP TABLE IF EXISTS `material_specs`;
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
                                  `update_by` varchar(64) DEFAULT '' COMMENT '更新至',
                                  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                  `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
                                  PRIMARY KEY (`id`) USING BTREE,
                                  UNIQUE KEY `specs_name` (`specs_name`) USING BTREE,
                                  KEY `category_code` (`category_code`) USING BTREE,
                                  KEY `specs_type` (`specs_type`) USING BTREE,
                                  KEY `is_deleted` (`is_deleted`) USING BTREE,
                                  CONSTRAINT `fk_categorycode` FOREIGN KEY (`category_code`) REFERENCES `material_category` (`code`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='物料规格表';

-- ----------------------------
-- Records of material_specs
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for po_contracts
-- ----------------------------
DROP TABLE IF EXISTS `po_contracts`;
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
                                `update_by` varchar(64) DEFAULT '' COMMENT '更新至',
                                `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
                                PRIMARY KEY (`id`) USING BTREE,
                                KEY `fk_PONum_PO_PONum` (`PONumber`) USING BTREE,
                                CONSTRAINT `fk_PONum_PO_PONum` FOREIGN KEY (`PONumber`) REFERENCES `purchase_order` (`PONumber`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='采购合同，一般由采购单(purchase order)转化而来';

-- ----------------------------
-- Records of po_contracts
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for projects
-- ----------------------------
DROP TABLE IF EXISTS `projects`;
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
                            `update_by` varchar(64) DEFAULT '' COMMENT '更新至',
                            `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                            `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
                            PRIMARY KEY (`id`) USING BTREE,
                            KEY `pro_code` (`pro_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='项目基本信息，不包含其他业务数据';

-- ----------------------------
-- Records of projects
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for purchase_order
-- ----------------------------
DROP TABLE IF EXISTS `purchase_order`;
CREATE TABLE `purchase_order` (
                                  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id作为主键',
                                  `PONumber` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '采购单号',
                                  `lessorUSC` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '租赁公司统一社会信用代码',
                                  `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
                                  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                                  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                  `update_by` varchar(64) DEFAULT '' COMMENT '更新至',
                                  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                  `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
                                  PRIMARY KEY (`id`) USING BTREE,
                                  KEY `PONumber` (`PONumber`) USING BTREE,
                                  KEY `fk_PO_lessorUSC` (`lessorUSC`) USING BTREE,
                                  CONSTRAINT `fk_PO_lessorUSC` FOREIGN KEY (`lessorUSC`) REFERENCES `lessor` (`usc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='采购单';

-- ----------------------------
-- Records of purchase_order
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for scg_organization
-- ----------------------------
DROP TABLE IF EXISTS `scg_organization`;
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
                                    `update_by` varchar(64) DEFAULT '' COMMENT '更新至',
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
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
                              `config_id` int NOT NULL AUTO_INCREMENT COMMENT '参数主键',
                              `config_name` varchar(100) DEFAULT '' COMMENT '参数名称',
                              `config_key` varchar(100) DEFAULT '' COMMENT '参数键名',
                              `config_value` varchar(500) DEFAULT '' COMMENT '参数键值',
                              `config_type` char(1) DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
                              `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                              `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                              `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
                              `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                              `remark` varchar(500) DEFAULT NULL COMMENT '备注' COMMENT '备注',
                              PRIMARY KEY (`config_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='参数配置表';

-- ----------------------------
-- Records of sys_config
-- ----------------------------
BEGIN;
INSERT INTO `sys_config` VALUES (1, '主框架页-默认皮肤样式名称', 'sys.index.skinName', 'skin-blue', 'Y', 'admin', '2022-02-25 09:43:09', '', NULL, '蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow');
INSERT INTO `sys_config` VALUES (2, '用户管理-账号初始密码', 'sys.user.initPassword', '123456', 'Y', 'admin', '2022-02-25 09:43:09', '', NULL, '初始化密码 123456');
INSERT INTO `sys_config` VALUES (3, '主框架页-侧边栏主题', 'sys.index.sideTheme', 'theme-dark', 'Y', 'admin', '2022-02-25 09:43:09', '', NULL, '深色主题theme-dark，浅色主题theme-light');
INSERT INTO `sys_config` VALUES (4, '账号自助-验证码开关', 'sys.account.captchaOnOff', 'true', 'Y', 'admin', '2022-02-25 09:43:09', '', NULL, '是否开启验证码功能（true开启，false关闭）');
INSERT INTO `sys_config` VALUES (5, '账号自助-是否开启用户注册功能', 'sys.account.registerUser', 'false', 'Y', 'admin', '2022-02-25 09:43:09', '', NULL, '是否开启注册用户功能（true开启，false关闭）');
COMMIT;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
                            `dept_id` bigint NOT NULL AUTO_INCREMENT COMMENT '部门id',
                            `parent_id` bigint DEFAULT '0' COMMENT '父部门id',
                            `ancestors` varchar(50) DEFAULT '' COMMENT '祖级列表',
                            `dept_name` varchar(30) DEFAULT '' COMMENT '部门名称',
                            `order_num` int DEFAULT '0' COMMENT '显示顺序',
                            `leader` varchar(20) DEFAULT NULL COMMENT '负责人',
                            `phone` varchar(11) DEFAULT NULL COMMENT '联系电话',
                            `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
                            `status` char(1) DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
                            `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
                            `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                            `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
                            `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                            PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='部门表';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
BEGIN;
INSERT INTO `sys_dept` VALUES (100, 0, '0', '若依科技', 0, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-02-25 09:43:08', '', NULL);
INSERT INTO `sys_dept` VALUES (101, 100, '0,100', '深圳总公司', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-02-25 09:43:08', '', NULL);
INSERT INTO `sys_dept` VALUES (102, 100, '0,100', '长沙分公司', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-02-25 09:43:08', '', NULL);
INSERT INTO `sys_dept` VALUES (103, 101, '0,100,101', '研发部门', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-02-25 09:43:08', '', NULL);
INSERT INTO `sys_dept` VALUES (104, 101, '0,100,101', '市场部门', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-02-25 09:43:08', '', NULL);
INSERT INTO `sys_dept` VALUES (105, 101, '0,100,101', '测试部门', 3, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-02-25 09:43:08', '', NULL);
INSERT INTO `sys_dept` VALUES (106, 101, '0,100,101', '财务部门', 4, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-02-25 09:43:08', '', NULL);
INSERT INTO `sys_dept` VALUES (107, 101, '0,100,101', '运维部门', 5, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-02-25 09:43:08', '', NULL);
INSERT INTO `sys_dept` VALUES (108, 102, '0,100,102', '市场部门', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-02-25 09:43:08', '', NULL);
INSERT INTO `sys_dept` VALUES (109, 102, '0,100,102', '财务部门', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-02-25 09:43:08', '', NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data` (
                                 `dict_code` bigint NOT NULL AUTO_INCREMENT COMMENT '字典编码',
                                 `dict_sort` int DEFAULT '0' COMMENT '字典排序',
                                 `dict_label` varchar(100) DEFAULT '' COMMENT '字典标签',
                                 `dict_value` varchar(100) DEFAULT '' COMMENT '字典键值',
                                 `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
                                 `css_class` varchar(100) DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
                                 `list_class` varchar(100) DEFAULT NULL COMMENT '表格回显样式',
                                 `is_default` char(1) DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
                                 `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
                                 `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                                 `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                 `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
                                 `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                 `remark` varchar(500) DEFAULT NULL COMMENT '备注',
                                 PRIMARY KEY (`dict_code`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='字典数据表';

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
BEGIN;
INSERT INTO `sys_dict_data` VALUES (1, 1, '男', '0', 'sys_user_sex', '', '', 'Y', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '性别男');
INSERT INTO `sys_dict_data` VALUES (2, 2, '女', '1', 'sys_user_sex', '', '', 'N', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '性别女');
INSERT INTO `sys_dict_data` VALUES (3, 3, '未知', '2', 'sys_user_sex', '', '', 'N', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '性别未知');
INSERT INTO `sys_dict_data` VALUES (4, 1, '显示', '0', 'sys_show_hide', '', 'primary', 'Y', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '显示菜单');
INSERT INTO `sys_dict_data` VALUES (5, 2, '隐藏', '1', 'sys_show_hide', '', 'danger', 'N', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '隐藏菜单');
INSERT INTO `sys_dict_data` VALUES (6, 1, '正常', '0', 'sys_normal_disable', '', 'primary', 'Y', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (7, 2, '停用', '1', 'sys_normal_disable', '', 'danger', 'N', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '停用状态');
INSERT INTO `sys_dict_data` VALUES (8, 1, '正常', '0', 'sys_job_status', '', 'primary', 'Y', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (9, 2, '暂停', '1', 'sys_job_status', '', 'danger', 'N', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '停用状态');
INSERT INTO `sys_dict_data` VALUES (10, 1, '默认', 'DEFAULT', 'sys_job_group', '', '', 'Y', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '默认分组');
INSERT INTO `sys_dict_data` VALUES (11, 2, '系统', 'SYSTEM', 'sys_job_group', '', '', 'N', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '系统分组');
INSERT INTO `sys_dict_data` VALUES (12, 1, '是', 'Y', 'sys_yes_no', '', 'primary', 'Y', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '系统默认是');
INSERT INTO `sys_dict_data` VALUES (13, 2, '否', 'N', 'sys_yes_no', '', 'danger', 'N', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '系统默认否');
INSERT INTO `sys_dict_data` VALUES (14, 1, '通知', '1', 'sys_notice_type', '', 'warning', 'Y', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '通知');
INSERT INTO `sys_dict_data` VALUES (15, 2, '公告', '2', 'sys_notice_type', '', 'success', 'N', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '公告');
INSERT INTO `sys_dict_data` VALUES (16, 1, '正常', '0', 'sys_notice_status', '', 'primary', 'Y', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (17, 2, '关闭', '1', 'sys_notice_status', '', 'danger', 'N', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '关闭状态');
INSERT INTO `sys_dict_data` VALUES (18, 1, '新增', '1', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '新增操作');
INSERT INTO `sys_dict_data` VALUES (19, 2, '修改', '2', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '修改操作');
INSERT INTO `sys_dict_data` VALUES (20, 3, '删除', '3', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '删除操作');
INSERT INTO `sys_dict_data` VALUES (21, 4, '授权', '4', 'sys_oper_type', '', 'primary', 'N', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '授权操作');
INSERT INTO `sys_dict_data` VALUES (22, 5, '导出', '5', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '导出操作');
INSERT INTO `sys_dict_data` VALUES (23, 6, '导入', '6', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '导入操作');
INSERT INTO `sys_dict_data` VALUES (24, 7, '强退', '7', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '强退操作');
INSERT INTO `sys_dict_data` VALUES (25, 8, '生成代码', '8', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '生成操作');
INSERT INTO `sys_dict_data` VALUES (26, 9, '清空数据', '9', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '清空操作');
INSERT INTO `sys_dict_data` VALUES (27, 1, '成功', '0', 'sys_common_status', '', 'primary', 'N', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (28, 2, '失败', '1', 'sys_common_status', '', 'danger', 'N', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '停用状态');
COMMIT;

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type` (
                                 `dict_id` bigint NOT NULL AUTO_INCREMENT COMMENT '字典主键',
                                 `dict_name` varchar(100) DEFAULT '' COMMENT '字典名称',
                                 `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
                                 `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
                                 `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                                 `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                 `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
                                 `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                 `remark` varchar(500) DEFAULT NULL COMMENT '备注',
                                 PRIMARY KEY (`dict_id`),
                                 UNIQUE KEY `dict_type` (`dict_type`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='字典类型表';

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
BEGIN;
INSERT INTO `sys_dict_type` VALUES (1, '用户性别', 'sys_user_sex', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '用户性别列表');
INSERT INTO `sys_dict_type` VALUES (2, '菜单状态', 'sys_show_hide', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '菜单状态列表');
INSERT INTO `sys_dict_type` VALUES (3, '系统开关', 'sys_normal_disable', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '系统开关列表');
INSERT INTO `sys_dict_type` VALUES (4, '任务状态', 'sys_job_status', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '任务状态列表');
INSERT INTO `sys_dict_type` VALUES (5, '任务分组', 'sys_job_group', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '任务分组列表');
INSERT INTO `sys_dict_type` VALUES (6, '系统是否', 'sys_yes_no', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '系统是否列表');
INSERT INTO `sys_dict_type` VALUES (7, '通知类型', 'sys_notice_type', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '通知类型列表');
INSERT INTO `sys_dict_type` VALUES (8, '通知状态', 'sys_notice_status', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '通知状态列表');
INSERT INTO `sys_dict_type` VALUES (9, '操作类型', 'sys_oper_type', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '操作类型列表');
INSERT INTO `sys_dict_type` VALUES (10, '系统状态', 'sys_common_status', '0', 'admin', '2022-02-25 09:43:09', '', NULL, '登录状态列表');
COMMIT;

-- ----------------------------
-- Table structure for sys_job
-- ----------------------------
DROP TABLE IF EXISTS `sys_job`;
CREATE TABLE `sys_job` (
                           `job_id` bigint NOT NULL AUTO_INCREMENT COMMENT '任务ID',
                           `job_name` varchar(64) NOT NULL DEFAULT '' COMMENT '任务名称',
                           `job_group` varchar(64) NOT NULL DEFAULT 'DEFAULT' COMMENT '任务组名',
                           `invoke_target` varchar(500) NOT NULL COMMENT '调用目标字符串',
                           `cron_expression` varchar(255) DEFAULT '' COMMENT 'cron执行表达式',
                           `misfire_policy` varchar(20) DEFAULT '3' COMMENT '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
                           `concurrent` char(1) DEFAULT '1' COMMENT '是否并发执行（0允许 1禁止）',
                           `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1暂停）',
                           `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                           `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                           `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
                           `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                           `remark` varchar(500) DEFAULT '' COMMENT '备注信息',
                           PRIMARY KEY (`job_id`,`job_name`,`job_group`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='定时任务调度表';

-- ----------------------------
-- Records of sys_job
-- ----------------------------
BEGIN;
INSERT INTO `sys_job` VALUES (1, '系统默认（无参）', 'DEFAULT', 'ryTask.ryNoParams', '0/10 * * * * ?', '3', '1', '1', 'admin', '2022-02-25 09:43:09', '', NULL, '');
INSERT INTO `sys_job` VALUES (2, '系统默认（有参）', 'DEFAULT', 'ryTask.ryParams(\'ry\')', '0/15 * * * * ?', '3', '1', '1', 'admin', '2022-02-25 09:43:09', '', NULL, '');
INSERT INTO `sys_job` VALUES (3, '系统默认（多参）', 'DEFAULT', 'ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)', '0/20 * * * * ?', '3', '1', '1', 'admin', '2022-02-25 09:43:09', '', NULL, '');
COMMIT;

-- ----------------------------
-- Table structure for sys_job_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_job_log`;
CREATE TABLE `sys_job_log` (
                               `job_log_id` bigint NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
                               `job_name` varchar(64) NOT NULL COMMENT '任务名称',
                               `job_group` varchar(64) NOT NULL COMMENT '任务组名',
                               `invoke_target` varchar(500) NOT NULL COMMENT '调用目标字符串',
                               `job_message` varchar(500) DEFAULT NULL COMMENT '日志信息',
                               `status` char(1) DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
                               `exception_info` varchar(2000) DEFAULT '' COMMENT '异常信息',
                               `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                               PRIMARY KEY (`job_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='定时任务调度日志表';

-- ----------------------------
-- Records of sys_job_log
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_logininfor
-- ----------------------------
DROP TABLE IF EXISTS `sys_logininfor`;
CREATE TABLE `sys_logininfor` (
                                  `info_id` bigint NOT NULL AUTO_INCREMENT COMMENT '访问ID',
                                  `user_name` varchar(50) DEFAULT '' COMMENT '用户账号',
                                  `ipaddr` varchar(128) DEFAULT '' COMMENT '登录IP地址',
                                  `login_location` varchar(255) DEFAULT '' COMMENT '登录地点',
                                  `browser` varchar(50) DEFAULT '' COMMENT '浏览器类型',
                                  `os` varchar(50) DEFAULT '' COMMENT '操作系统',
                                  `status` char(1) DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
                                  `msg` varchar(255) DEFAULT '' COMMENT '提示消息',
                                  `login_time` datetime DEFAULT NULL COMMENT '访问时间',
                                  PRIMARY KEY (`info_id`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统访问记录';

-- ----------------------------
-- Records of sys_logininfor
-- ----------------------------
BEGIN;
INSERT INTO `sys_logininfor` VALUES (100, 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Mac OS X', '0', '登录成功', '2022-02-28 14:48:35');
INSERT INTO `sys_logininfor` VALUES (101, 'admin', '10.36.32.168', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-02-28 15:05:12');
INSERT INTO `sys_logininfor` VALUES (102, 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Mac OS X', '0', '登录成功', '2022-02-28 15:21:47');
INSERT INTO `sys_logininfor` VALUES (103, 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Mac OS X', '0', '登录成功', '2022-02-28 15:33:01');
INSERT INTO `sys_logininfor` VALUES (104, 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Mac OS X', '0', '登录成功', '2022-03-02 15:40:39');
INSERT INTO `sys_logininfor` VALUES (105, 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Mac OS X', '0', '登录成功', '2022-03-03 14:52:50');
INSERT INTO `sys_logininfor` VALUES (106, 'admin', '10.36.5.12', '内网IP', 'Chrome 9', 'Windows 10', '1', '验证码错误', '2022-03-03 17:45:00');
INSERT INTO `sys_logininfor` VALUES (107, 'admin', '10.36.5.12', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2022-03-03 17:45:05');
INSERT INTO `sys_logininfor` VALUES (108, 'admin', '10.36.32.168', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2022-03-04 09:49:59');
COMMIT;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
                            `menu_id` bigint NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
                            `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
                            `parent_id` bigint DEFAULT '0' COMMENT '父菜单ID',
                            `order_num` int DEFAULT '0' COMMENT '显示顺序',
                            `path` varchar(200) DEFAULT '' COMMENT '路由地址',
                            `component` varchar(255) DEFAULT NULL COMMENT '组件路径',
                            `query` varchar(255) DEFAULT NULL COMMENT '路由参数',
                            `is_frame` int DEFAULT '1' COMMENT '是否为外链（0是 1否）',
                            `is_cache` int DEFAULT '0' COMMENT '是否缓存（0缓存 1不缓存）',
                            `menu_type` char(1) DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
                            `visible` char(1) DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
                            `status` char(1) DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
                            `perms` varchar(100) DEFAULT NULL COMMENT '权限标识',
                            `icon` varchar(100) DEFAULT '#' COMMENT '菜单图标',
                            `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                            `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
                            `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                            `remark` varchar(500) DEFAULT '' COMMENT '备注',
                            PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2026 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='菜单权限表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_menu` VALUES (1, '系统管理', 0, 1, 'system', NULL, '', 1, 0, 'M', '0', '0', '', 'system', 'admin', '2022-02-25 09:43:08', '', NULL, '系统管理目录');
INSERT INTO `sys_menu` VALUES (2, '系统监控', 0, 2, 'monitor', NULL, '', 1, 0, 'M', '0', '0', '', 'monitor', 'admin', '2022-02-25 09:43:08', '', NULL, '系统监控目录');
INSERT INTO `sys_menu` VALUES (3, '系统工具', 0, 3, 'tool', NULL, '', 1, 0, 'M', '0', '0', '', 'tool', 'admin', '2022-02-25 09:43:08', '', NULL, '系统工具目录');
INSERT INTO `sys_menu` VALUES (100, '用户管理', 1, 1, 'user', 'system/user/index', '', 1, 0, 'C', '0', '0', 'system:user:list', 'user', 'admin', '2022-02-25 09:43:08', '', NULL, '用户管理菜单');
INSERT INTO `sys_menu` VALUES (101, '角色管理', 1, 2, 'role', 'system/role/index', '', 1, 0, 'C', '0', '0', 'system:role:list', 'peoples', 'admin', '2022-02-25 09:43:08', '', NULL, '角色管理菜单');
INSERT INTO `sys_menu` VALUES (102, '菜单管理', 1, 3, 'menu', 'system/menu/index', '', 1, 0, 'C', '0', '0', 'system:menu:list', 'tree-table', 'admin', '2022-02-25 09:43:08', '', NULL, '菜单管理菜单');
INSERT INTO `sys_menu` VALUES (103, '部门管理', 1, 4, 'dept', 'system/dept/index', '', 1, 0, 'C', '0', '0', 'system:dept:list', 'tree', 'admin', '2022-02-25 09:43:08', '', NULL, '部门管理菜单');
INSERT INTO `sys_menu` VALUES (104, '岗位管理', 1, 5, 'post', 'system/post/index', '', 1, 0, 'C', '0', '0', 'system:post:list', 'post', 'admin', '2022-02-25 09:43:08', '', NULL, '岗位管理菜单');
INSERT INTO `sys_menu` VALUES (105, '字典管理', 1, 6, 'dict', 'system/dict/index', '', 1, 0, 'C', '0', '0', 'system:dict:list', 'dict', 'admin', '2022-02-25 09:43:08', '', NULL, '字典管理菜单');
INSERT INTO `sys_menu` VALUES (106, '参数设置', 1, 7, 'config', 'system/config/index', '', 1, 0, 'C', '0', '0', 'system:config:list', 'edit', 'admin', '2022-02-25 09:43:08', '', NULL, '参数设置菜单');
INSERT INTO `sys_menu` VALUES (107, '通知公告', 1, 8, 'notice', 'system/notice/index', '', 1, 0, 'C', '0', '0', 'system:notice:list', 'message', 'admin', '2022-02-25 09:43:08', '', NULL, '通知公告菜单');
INSERT INTO `sys_menu` VALUES (108, '日志管理', 1, 9, 'log', '', '', 1, 0, 'M', '0', '0', '', 'log', 'admin', '2022-02-25 09:43:08', '', NULL, '日志管理菜单');
INSERT INTO `sys_menu` VALUES (109, '在线用户', 2, 1, 'online', 'monitor/online/index', '', 1, 0, 'C', '0', '0', 'monitor:online:list', 'online', 'admin', '2022-02-25 09:43:08', '', NULL, '在线用户菜单');
INSERT INTO `sys_menu` VALUES (110, '定时任务', 2, 2, 'job', 'monitor/job/index', '', 1, 0, 'C', '0', '0', 'monitor:job:list', 'job', 'admin', '2022-02-25 09:43:08', '', NULL, '定时任务菜单');
INSERT INTO `sys_menu` VALUES (111, '数据监控', 2, 3, 'druid', 'monitor/druid/index', '', 1, 0, 'C', '0', '0', 'monitor:druid:list', 'druid', 'admin', '2022-02-25 09:43:08', '', NULL, '数据监控菜单');
INSERT INTO `sys_menu` VALUES (112, '服务监控', 2, 4, 'server', 'monitor/server/index', '', 1, 0, 'C', '0', '0', 'monitor:server:list', 'server', 'admin', '2022-02-25 09:43:08', '', NULL, '服务监控菜单');
INSERT INTO `sys_menu` VALUES (113, '缓存监控', 2, 5, 'cache', 'monitor/cache/index', '', 1, 0, 'C', '0', '0', 'monitor:cache:list', 'redis', 'admin', '2022-02-25 09:43:08', '', NULL, '缓存监控菜单');
INSERT INTO `sys_menu` VALUES (114, '表单构建', 3, 1, 'build', 'tool/build/index', '', 1, 0, 'C', '0', '0', 'tool:build:list', 'build', 'admin', '2022-02-25 09:43:08', '', NULL, '表单构建菜单');
INSERT INTO `sys_menu` VALUES (115, '代码生成', 3, 2, 'gen', 'tool/gen/index', '', 1, 0, 'C', '0', '0', 'tool:gen:list', 'code', 'admin', '2022-02-25 09:43:08', '', NULL, '代码生成菜单');
INSERT INTO `sys_menu` VALUES (116, '系统接口', 3, 3, 'swagger', 'tool/swagger/index', '', 1, 0, 'C', '0', '0', 'tool:swagger:list', 'swagger', 'admin', '2022-02-25 09:43:08', '', NULL, '系统接口菜单');
INSERT INTO `sys_menu` VALUES (500, '操作日志', 108, 1, 'operlog', 'monitor/operlog/index', '', 1, 0, 'C', '0', '0', 'monitor:operlog:list', 'form', 'admin', '2022-02-25 09:43:08', '', NULL, '操作日志菜单');
INSERT INTO `sys_menu` VALUES (501, '登录日志', 108, 2, 'logininfor', 'monitor/logininfor/index', '', 1, 0, 'C', '0', '0', 'monitor:logininfor:list', 'logininfor', 'admin', '2022-02-25 09:43:08', '', NULL, '登录日志菜单');
INSERT INTO `sys_menu` VALUES (1001, '用户查询', 100, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:user:query', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1002, '用户新增', 100, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:user:add', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1003, '用户修改', 100, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:user:edit', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1004, '用户删除', 100, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:user:remove', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1005, '用户导出', 100, 5, '', '', '', 1, 0, 'F', '0', '0', 'system:user:export', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1006, '用户导入', 100, 6, '', '', '', 1, 0, 'F', '0', '0', 'system:user:import', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1007, '重置密码', 100, 7, '', '', '', 1, 0, 'F', '0', '0', 'system:user:resetPwd', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1008, '角色查询', 101, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:role:query', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1009, '角色新增', 101, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:role:add', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1010, '角色修改', 101, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:role:edit', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1011, '角色删除', 101, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:role:remove', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1012, '角色导出', 101, 5, '', '', '', 1, 0, 'F', '0', '0', 'system:role:export', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1013, '菜单查询', 102, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:query', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1014, '菜单新增', 102, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:add', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1015, '菜单修改', 102, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:edit', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1016, '菜单删除', 102, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:remove', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1017, '部门查询', 103, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:query', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1018, '部门新增', 103, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:add', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1019, '部门修改', 103, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:edit', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1020, '部门删除', 103, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:remove', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1021, '岗位查询', 104, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:post:query', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1022, '岗位新增', 104, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:post:add', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1023, '岗位修改', 104, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:post:edit', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1024, '岗位删除', 104, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:post:remove', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1025, '岗位导出', 104, 5, '', '', '', 1, 0, 'F', '0', '0', 'system:post:export', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1026, '字典查询', 105, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:query', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1027, '字典新增', 105, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:add', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1028, '字典修改', 105, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:edit', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1029, '字典删除', 105, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:remove', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1030, '字典导出', 105, 5, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:export', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1031, '参数查询', 106, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:query', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1032, '参数新增', 106, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:add', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1033, '参数修改', 106, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:edit', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1034, '参数删除', 106, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:remove', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1035, '参数导出', 106, 5, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:export', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1036, '公告查询', 107, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:query', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1037, '公告新增', 107, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:add', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1038, '公告修改', 107, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:edit', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1039, '公告删除', 107, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:remove', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1040, '操作查询', 500, 1, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:operlog:query', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1041, '操作删除', 500, 2, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:operlog:remove', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1042, '日志导出', 500, 4, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:operlog:export', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1043, '登录查询', 501, 1, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:query', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1044, '登录删除', 501, 2, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:remove', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1045, '日志导出', 501, 3, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:export', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1046, '在线查询', 109, 1, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:query', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1047, '批量强退', 109, 2, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:batchLogout', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1048, '单条强退', 109, 3, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:forceLogout', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1049, '任务查询', 110, 1, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:query', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1050, '任务新增', 110, 2, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:add', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1051, '任务修改', 110, 3, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:edit', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1052, '任务删除', 110, 4, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:remove', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1053, '状态修改', 110, 5, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:changeStatus', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1054, '任务导出', 110, 7, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:export', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1055, '生成查询', 115, 1, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:query', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1056, '生成修改', 115, 2, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:edit', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1057, '生成删除', 115, 3, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:remove', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1058, '导入代码', 115, 2, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:import', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1059, '预览代码', 115, 4, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:preview', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1060, '生成代码', 115, 5, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:code', '#', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2000, '库存出入库总', 3, 1, 'inventory', 'system/inventory/index', NULL, 1, 0, 'C', '0', '0', 'system:inventory:list', '#', 'admin', '2022-02-28 15:03:43', '', NULL, '库存出入库总菜单');
INSERT INTO `sys_menu` VALUES (2001, '库存出入库总查询', 2000, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'system:inventory:query', '#', 'admin', '2022-02-28 15:03:43', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2002, '库存出入库总新增', 2000, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'system:inventory:add', '#', 'admin', '2022-02-28 15:03:43', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2003, '库存出入库总修改', 2000, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'system:inventory:edit', '#', 'admin', '2022-02-28 15:03:43', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2004, '库存出入库总删除', 2000, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'system:inventory:remove', '#', 'admin', '2022-02-28 15:03:43', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2005, '库存出入库总导出', 2000, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'system:inventory:export', '#', 'admin', '2022-02-28 15:03:43', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2019, '基础设置', 0, 4, 'setting', NULL, NULL, 1, 0, 'M', '0', '0', NULL, 'dict', 'admin', '2022-03-03 15:22:53', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2020, '仓库管理', 2019, 1, 'warehouse', 'setting/warehouse/index', NULL, 1, 0, 'C', '0', '0', 'setting:warehouse:list', 'redis', 'admin', '2022-03-03 15:24:11', 'admin', '2022-03-04 11:55:43', '仓库管理菜单');
INSERT INTO `sys_menu` VALUES (2021, '仓库管理查询', 2020, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'business:warehouse:query', '#', 'admin', '2022-03-03 15:24:11', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2022, '仓库管理新增', 2020, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'business:warehouse:add', '#', 'admin', '2022-03-03 15:24:11', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2023, '仓库管理修改', 2020, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'business:warehouse:edit', '#', 'admin', '2022-03-03 15:24:11', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2024, '仓库管理删除', 2020, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'business:warehouse:remove', '#', 'admin', '2022-03-03 15:24:11', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2025, '仓库管理导出', 2020, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'business:warehouse:export', '#', 'admin', '2022-03-03 15:24:11', '', NULL, '');
COMMIT;

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice` (
                              `notice_id` int NOT NULL AUTO_INCREMENT COMMENT '公告ID',
                              `notice_title` varchar(50) NOT NULL COMMENT '公告标题',
                              `notice_type` char(1) NOT NULL COMMENT '公告类型（1通知 2公告）',
                              `notice_content` longblob COMMENT '公告内容',
                              `status` char(1) DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
                              `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                              `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                              `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
                              `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                              `remark` varchar(255) DEFAULT NULL COMMENT '备注',
                              PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='通知公告表';

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
BEGIN;
INSERT INTO `sys_notice` VALUES (1, '温馨提醒：2018-07-01 若依新版本发布啦', '2', 0xE696B0E78988E69CACE58685E5AEB9, '0', 'admin', '2022-02-25 09:43:09', '', NULL, '管理员');
INSERT INTO `sys_notice` VALUES (2, '维护通知：2018-07-01 若依系统凌晨维护', '1', 0xE7BBB4E68AA4E58685E5AEB9, '0', 'admin', '2022-02-25 09:43:09', '', NULL, '管理员');
COMMIT;

-- ----------------------------
-- Table structure for sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log` (
                                `oper_id` bigint NOT NULL AUTO_INCREMENT COMMENT '日志主键',
                                `title` varchar(50) DEFAULT '' COMMENT '模块标题',
                                `business_type` int DEFAULT '0' COMMENT '业务类型（0其它 1新增 2修改 3删除）',
                                `method` varchar(100) DEFAULT '' COMMENT '方法名称',
                                `request_method` varchar(10) DEFAULT '' COMMENT '请求方式',
                                `operator_type` int DEFAULT '0' COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
                                `oper_name` varchar(50) DEFAULT '' COMMENT '操作人员',
                                `dept_name` varchar(50) DEFAULT '' COMMENT '部门名称',
                                `oper_url` varchar(255) DEFAULT '' COMMENT '请求URL',
                                `oper_ip` varchar(128) DEFAULT '' COMMENT '主机地址',
                                `oper_location` varchar(255) DEFAULT '' COMMENT '操作地点',
                                `oper_param` varchar(2000) DEFAULT '' COMMENT '请求参数',
                                `json_result` varchar(2000) DEFAULT '' COMMENT '返回参数',
                                `status` int DEFAULT '0' COMMENT '操作状态（0正常 1异常）',
                                `error_msg` varchar(2000) DEFAULT '' COMMENT '错误消息',
                                `oper_time` datetime DEFAULT NULL COMMENT '操作时间',
                                PRIMARY KEY (`oper_id`)
) ENGINE=InnoDB AUTO_INCREMENT=136 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='操作日志记录';

-- ----------------------------
-- Records of sys_oper_log
-- ----------------------------
BEGIN;
INSERT INTO `sys_oper_log` VALUES (100, '代码生成', 6, 'com.ruoyi.generator.controller.GenController.importTableSave()', 'POST', 1, 'admin', NULL, '/tool/gen/importTable', '127.0.0.1', '内网IP', 'inventory,inventory_detail', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-28 14:53:33');
INSERT INTO `sys_oper_log` VALUES (101, '代码生成', 8, 'com.ruoyi.generator.controller.GenController.batchGenCode()', 'GET', 1, 'admin', NULL, '/tool/gen/batchGenCode', '127.0.0.1', '内网IP', '{}', NULL, 0, NULL, '2022-02-28 14:57:06');
INSERT INTO `sys_oper_log` VALUES (102, '代码生成', 8, 'com.ruoyi.generator.controller.GenController.batchGenCode()', 'GET', 1, 'admin', NULL, '/tool/gen/batchGenCode', '127.0.0.1', '内网IP', '{}', NULL, 0, NULL, '2022-02-28 15:38:24');
INSERT INTO `sys_oper_log` VALUES (103, '代码生成', 2, 'com.ruoyi.generator.controller.GenController.synchDb()', 'GET', 1, 'admin', NULL, '/tool/gen/synchDb/inventory', '127.0.0.1', '内网IP', '{tableName=inventory}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-28 15:44:53');
INSERT INTO `sys_oper_log` VALUES (104, '代码生成', 2, 'com.ruoyi.generator.controller.GenController.editSave()', 'PUT', 1, 'admin', NULL, '/tool/gen', '127.0.0.1', '内网IP', '{\"sub\":true,\"subTableName\":\"inventory_detail\",\"functionAuthor\":\"ruoyi\",\"columns\":[{\"capJavaField\":\"Id\",\"usableColumn\":false,\"columnId\":1,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"required\":false,\"superColumn\":false,\"isInsert\":\"1\",\"javaField\":\"id\",\"htmlType\":\"input\",\"edit\":false,\"query\":false,\"columnComment\":\"Guid作为主键\",\"updateTime\":1646034292000,\"sort\":1,\"list\":false,\"params\":{},\"javaType\":\"String\",\"queryType\":\"EQ\",\"columnType\":\"varchar(36)\",\"createBy\":\"admin\",\"isPk\":\"1\",\"createTime\":1646031212000,\"tableId\":1,\"pk\":true,\"columnName\":\"id\"},{\"capJavaField\":\"Warehouseid\",\"usableColumn\":false,\"columnId\":2,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"warehouseid\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"\",\"isQuery\":\"1\",\"updateTime\":1646034292000,\"sort\":2,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"EQ\",\"columnType\":\"varchar(36)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1646031212000,\"isEdit\":\"1\",\"tableId\":1,\"pk\":false,\"columnName\":\"warehouseid\"},{\"capJavaField\":\"StockInoutNo\",\"usableColumn\":false,\"columnId\":3,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"stockInoutNo\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"出入库单号，流水单号，自动生成\",\"isQuery\":\"1\",\"updateTime\":1646034292000,\"sort\":3,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"EQ\",\"columnType\":\"varchar(20)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1646031212000,\"isEdit\":\"1\",\"tableId\":1,\"pk\":false,\"columnName\":\"stock_inout_no\"},{\"capJavaField\":\"StockDirection\",\"usableColumn\":false,\"columnId\":4,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"stockDirection\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"入库还是出库：0为入库，', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-28 15:53:18');
INSERT INTO `sys_oper_log` VALUES (105, '代码生成', 6, 'com.ruoyi.generator.controller.GenController.importTableSave()', 'POST', 1, 'admin', NULL, '/tool/gen/importTable', '127.0.0.1', '内网IP', 'warehouse', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-03-03 14:53:10');
INSERT INTO `sys_oper_log` VALUES (106, '代码生成', 2, 'com.ruoyi.generator.controller.GenController.editSave()', 'PUT', 1, 'admin', NULL, '/tool/gen', '127.0.0.1', '内网IP', '{\"sub\":false,\"functionAuthor\":\"ruoyi\",\"columns\":[{\"capJavaField\":\"Id\",\"usableColumn\":false,\"columnId\":45,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"id\",\"htmlType\":\"input\",\"edit\":false,\"query\":false,\"sort\":1,\"list\":false,\"params\":{},\"javaType\":\"String\",\"queryType\":\"EQ\",\"columnType\":\"varchar(36)\",\"createBy\":\"admin\",\"isPk\":\"1\",\"createTime\":1646290390000,\"tableId\":3,\"pk\":true,\"columnName\":\"id\"},{\"capJavaField\":\"Lessorusc\",\"usableColumn\":false,\"columnId\":46,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"lessorusc\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"租赁公司统一社会信用代码\",\"isQuery\":\"1\",\"sort\":2,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"EQ\",\"columnType\":\"varchar(18)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1646290390000,\"isEdit\":\"1\",\"tableId\":3,\"pk\":false,\"columnName\":\"lessorUSC\"},{\"capJavaField\":\"Name\",\"usableColumn\":false,\"columnId\":47,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"name\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"仓库名称\",\"isQuery\":\"1\",\"sort\":3,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"LIKE\",\"columnType\":\"varchar(255)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1646290390000,\"isEdit\":\"1\",\"tableId\":3,\"pk\":false,\"columnName\":\"name\"},{\"capJavaField\":\"Address\",\"usableColumn\":false,\"columnId\":48,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"address\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"仓库地址\",\"isQuery\":\"1\",\"sort\":4,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"EQ\",\"columnType\":\"varchar(255)\",\"cr', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-03-03 15:02:20');
INSERT INTO `sys_oper_log` VALUES (107, '代码生成', 2, 'com.ruoyi.generator.controller.GenController.editSave()', 'PUT', 1, 'admin', NULL, '/tool/gen', '127.0.0.1', '内网IP', '{\"sub\":false,\"functionAuthor\":\"ruoyi\",\"columns\":[{\"capJavaField\":\"Id\",\"usableColumn\":false,\"columnId\":45,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"id\",\"htmlType\":\"input\",\"edit\":false,\"query\":false,\"updateTime\":1646290939000,\"sort\":1,\"list\":false,\"params\":{},\"javaType\":\"String\",\"queryType\":\"EQ\",\"columnType\":\"varchar(36)\",\"createBy\":\"admin\",\"isPk\":\"1\",\"createTime\":1646290390000,\"tableId\":3,\"pk\":true,\"columnName\":\"id\"},{\"capJavaField\":\"Lessorusc\",\"usableColumn\":false,\"columnId\":46,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"lessorusc\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"租赁公司统一社会信用代码\",\"isQuery\":\"1\",\"updateTime\":1646290939000,\"sort\":2,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"EQ\",\"columnType\":\"varchar(18)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1646290390000,\"isEdit\":\"1\",\"tableId\":3,\"pk\":false,\"columnName\":\"lessorUSC\"},{\"capJavaField\":\"Name\",\"usableColumn\":false,\"columnId\":47,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"name\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"仓库名称\",\"isQuery\":\"1\",\"updateTime\":1646290939000,\"sort\":3,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"LIKE\",\"columnType\":\"varchar(255)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1646290390000,\"isEdit\":\"1\",\"tableId\":3,\"pk\":false,\"columnName\":\"name\"},{\"capJavaField\":\"Address\",\"usableColumn\":false,\"columnId\":48,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"address\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"仓库地址\",\"isQuery\":\"1\",\"updateTime\":1646290', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-03-03 15:03:31');
INSERT INTO `sys_oper_log` VALUES (108, '代码生成', 8, 'com.ruoyi.generator.controller.GenController.genCode()', 'GET', 1, 'admin', NULL, '/tool/gen/genCode/warehouse', '127.0.0.1', '内网IP', '{tableName=warehouse}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-03-03 15:04:25');
INSERT INTO `sys_oper_log` VALUES (109, '菜单管理', 1, 'com.ruoyi.web.controller.system.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"server\",\"orderNum\":4,\"menuName\":\"基础设置\",\"params\":{},\"parentId\":0,\"isCache\":\"0\",\"path\":\"setting\",\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"C\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-03-03 15:17:03');
INSERT INTO `sys_oper_log` VALUES (110, '代码生成', 2, 'com.ruoyi.generator.controller.GenController.editSave()', 'PUT', 1, 'admin', NULL, '/tool/gen', '127.0.0.1', '内网IP', '{\"sub\":false,\"functionAuthor\":\"ruoyi\",\"columns\":[{\"capJavaField\":\"Id\",\"usableColumn\":false,\"columnId\":45,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"id\",\"htmlType\":\"input\",\"edit\":false,\"query\":false,\"updateTime\":1646291011000,\"sort\":1,\"list\":false,\"params\":{},\"javaType\":\"String\",\"queryType\":\"EQ\",\"columnType\":\"varchar(36)\",\"createBy\":\"admin\",\"isPk\":\"1\",\"createTime\":1646290390000,\"tableId\":3,\"pk\":true,\"columnName\":\"id\"},{\"capJavaField\":\"Lessorusc\",\"usableColumn\":false,\"columnId\":46,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"lessorusc\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"租赁公司统一社会信用代码\",\"isQuery\":\"1\",\"updateTime\":1646291011000,\"sort\":2,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"EQ\",\"columnType\":\"varchar(18)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1646290390000,\"isEdit\":\"1\",\"tableId\":3,\"pk\":false,\"columnName\":\"lessorUSC\"},{\"capJavaField\":\"Name\",\"usableColumn\":false,\"columnId\":47,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"name\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"仓库名称\",\"isQuery\":\"1\",\"updateTime\":1646291011000,\"sort\":3,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"LIKE\",\"columnType\":\"varchar(255)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1646290390000,\"isEdit\":\"1\",\"tableId\":3,\"pk\":false,\"columnName\":\"name\"},{\"capJavaField\":\"Address\",\"usableColumn\":false,\"columnId\":48,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"address\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"仓库地址\",\"isQuery\":\"1\",\"updateTime\":1646291', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-03-03 15:18:01');
INSERT INTO `sys_oper_log` VALUES (111, '菜单管理', 3, 'com.ruoyi.web.controller.system.SysMenuController.remove()', 'DELETE', 1, 'admin', NULL, '/system/menu/2013', '127.0.0.1', '内网IP', '{menuId=2013}', '{\"msg\":\"存在子菜单,不允许删除\",\"code\":500}', 0, NULL, '2022-03-03 15:20:59');
INSERT INTO `sys_oper_log` VALUES (112, '菜单管理', 3, 'com.ruoyi.web.controller.system.SysMenuController.remove()', 'DELETE', 1, 'admin', NULL, '/system/menu/2014', '127.0.0.1', '内网IP', '{menuId=2014}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-03-03 15:21:08');
INSERT INTO `sys_oper_log` VALUES (113, '菜单管理', 3, 'com.ruoyi.web.controller.system.SysMenuController.remove()', 'DELETE', 1, 'admin', NULL, '/system/menu/2015', '127.0.0.1', '内网IP', '{menuId=2015}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-03-03 15:21:11');
INSERT INTO `sys_oper_log` VALUES (114, '菜单管理', 3, 'com.ruoyi.web.controller.system.SysMenuController.remove()', 'DELETE', 1, 'admin', NULL, '/system/menu/2016', '127.0.0.1', '内网IP', '{menuId=2016}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-03-03 15:21:16');
INSERT INTO `sys_oper_log` VALUES (115, '菜单管理', 3, 'com.ruoyi.web.controller.system.SysMenuController.remove()', 'DELETE', 1, 'admin', NULL, '/system/menu/2017', '127.0.0.1', '内网IP', '{menuId=2017}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-03-03 15:21:18');
INSERT INTO `sys_oper_log` VALUES (116, '菜单管理', 3, 'com.ruoyi.web.controller.system.SysMenuController.remove()', 'DELETE', 1, 'admin', NULL, '/system/menu/2018', '127.0.0.1', '内网IP', '{menuId=2018}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-03-03 15:21:20');
INSERT INTO `sys_oper_log` VALUES (117, '菜单管理', 3, 'com.ruoyi.web.controller.system.SysMenuController.remove()', 'DELETE', 1, 'admin', NULL, '/system/menu/2013', '127.0.0.1', '内网IP', '{menuId=2013}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-03-03 15:21:24');
INSERT INTO `sys_oper_log` VALUES (118, '菜单管理', 1, 'com.ruoyi.web.controller.system.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"dict\",\"orderNum\":4,\"menuName\":\"基础设置\",\"params\":{},\"parentId\":0,\"isCache\":\"0\",\"path\":\"setting\",\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"M\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-03-03 15:22:53');
INSERT INTO `sys_oper_log` VALUES (119, '代码生成', 2, 'com.ruoyi.generator.controller.GenController.editSave()', 'PUT', 1, 'admin', NULL, '/tool/gen', '127.0.0.1', '内网IP', '{\"sub\":false,\"functionAuthor\":\"ruoyi\",\"columns\":[{\"capJavaField\":\"Id\",\"usableColumn\":false,\"columnId\":45,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"id\",\"htmlType\":\"input\",\"edit\":false,\"query\":false,\"updateTime\":1646291881000,\"sort\":1,\"list\":false,\"params\":{},\"javaType\":\"String\",\"queryType\":\"EQ\",\"columnType\":\"varchar(36)\",\"createBy\":\"admin\",\"isPk\":\"1\",\"createTime\":1646290390000,\"tableId\":3,\"pk\":true,\"columnName\":\"id\"},{\"capJavaField\":\"Lessorusc\",\"usableColumn\":false,\"columnId\":46,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"lessorusc\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"租赁公司统一社会信用代码\",\"isQuery\":\"1\",\"updateTime\":1646291881000,\"sort\":2,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"EQ\",\"columnType\":\"varchar(18)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1646290390000,\"isEdit\":\"1\",\"tableId\":3,\"pk\":false,\"columnName\":\"lessorUSC\"},{\"capJavaField\":\"Name\",\"usableColumn\":false,\"columnId\":47,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"name\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"仓库名称\",\"isQuery\":\"1\",\"updateTime\":1646291881000,\"sort\":3,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"LIKE\",\"columnType\":\"varchar(255)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1646290390000,\"isEdit\":\"1\",\"tableId\":3,\"pk\":false,\"columnName\":\"name\"},{\"capJavaField\":\"Address\",\"usableColumn\":false,\"columnId\":48,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"address\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"仓库地址\",\"isQuery\":\"1\",\"updateTime\":1646291', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-03-03 15:23:43');
INSERT INTO `sys_oper_log` VALUES (120, '代码生成', 6, 'com.ruoyi.generator.controller.GenController.importTableSave()', 'POST', 1, 'admin', NULL, '/tool/gen/importTable', '10.36.5.12', '内网IP', 'sys_role', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-03-03 17:50:43');
INSERT INTO `sys_oper_log` VALUES (121, '代码生成', 8, 'com.ruoyi.generator.controller.GenController.genCode()', 'GET', 1, 'admin', NULL, '/tool/gen/genCode/warehouse', '127.0.0.1', '内网IP', '{tableName=warehouse}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-03-03 18:03:59');
INSERT INTO `sys_oper_log` VALUES (122, '代码生成', 2, 'com.ruoyi.generator.controller.GenController.editSave()', 'PUT', 1, 'admin', NULL, '/tool/gen', '127.0.0.1', '内网IP', '{\"sub\":false,\"functionAuthor\":\"ruoyi\",\"columns\":[{\"capJavaField\":\"RoleId\",\"usableColumn\":false,\"columnId\":58,\"isIncrement\":\"1\",\"increment\":true,\"insert\":true,\"dictType\":\"\",\"required\":false,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"javaField\":\"roleId\",\"htmlType\":\"input\",\"edit\":false,\"query\":false,\"columnComment\":\"角色ID\",\"sort\":1,\"list\":false,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",\"columnType\":\"bigint\",\"createBy\":\"admin\",\"isPk\":\"1\",\"createTime\":1646301043000,\"tableId\":4,\"pk\":true,\"columnName\":\"role_id\"},{\"capJavaField\":\"RoleName\",\"usableColumn\":false,\"columnId\":59,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"roleName\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"角色名称\",\"isQuery\":\"1\",\"sort\":2,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"LIKE\",\"columnType\":\"varchar(30)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1646301043000,\"isEdit\":\"1\",\"tableId\":4,\"pk\":false,\"columnName\":\"role_name\"},{\"capJavaField\":\"RoleKey\",\"usableColumn\":false,\"columnId\":60,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"roleKey\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"角色权限字符串\",\"isQuery\":\"1\",\"sort\":3,\"list\":true,\"params\":{},\"javaType\":\"String\",\"queryType\":\"EQ\",\"columnType\":\"varchar(100)\",\"createBy\":\"admin\",\"isPk\":\"0\",\"createTime\":1646301043000,\"isEdit\":\"1\",\"tableId\":4,\"pk\":false,\"columnName\":\"role_key\"},{\"capJavaField\":\"RoleSort\",\"usableColumn\":false,\"columnId\":61,\"isIncrement\":\"0\",\"increment\":false,\"insert\":true,\"isList\":\"1\",\"dictType\":\"\",\"required\":true,\"superColumn\":false,\"updateBy\":\"\",\"isInsert\":\"1\",\"isRequired\":\"1\",\"javaField\":\"roleSort\",\"htmlType\":\"input\",\"edit\":true,\"query\":true,\"columnComment\":\"显示顺序\",\"isQuery\":\"1\",\"sort\":4,\"list\":true,\"params\":{},\"javaType\":\"Long\",\"queryType\":\"EQ\",', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-03-03 18:06:03');
INSERT INTO `sys_oper_log` VALUES (123, '代码生成', 8, 'com.ruoyi.generator.controller.GenController.genCode()', 'GET', 1, 'admin', NULL, '/tool/gen/genCode/sys_role', '127.0.0.1', '内网IP', '{tableName=sys_role}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-03-03 18:06:06');
INSERT INTO `sys_oper_log` VALUES (124, '仓库', 1, 'com.ruoyi.business.controller.WarehouseController.add()', 'POST', 1, 'admin', NULL, '/api/v2/business/warehouse', '127.0.0.1', '内网IP', '{\"modifiedName\":\"string\",\"address\":\"string\",\"keeper\":\"string\",\"remark\":\"string\",\"params\":{},\"createBy\":\"string\",\"isDeleted\":\"string\",\"createdBy\":0,\"updateBy\":\"string\",\"lessorusc\":\"string\",\"name\":\"string\",\"createdName\":\"string\",\"modifiedBy\":0,\"id\":\"string\",\"searchValue\":\"string\"}', NULL, 1, '\n### Error updating database.  Cause: com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Data too long for column \'is_deleted\' at row 1\n### The error may exist in file [/Users/zhapeng/Documents/GitHub/RuoYi-Vue/ruoyi-business/target/classes/mapper/business/WarehouseMapper.xml]\n### The error may involve com.ruoyi.business.mapper.WarehouseMapper.insertWarehouse-Inline\n### The error occurred while setting parameters\n### SQL: insert into warehouse          ( id,                                          lessorUSC,                                          name,                                          Address,                                                               created_by,                                                               modified_by,                                          created_name,                                          modified_name,                                          is_deleted,                                          keeper,                                          remark )           values ( ?,                                          ?,                                          ?,                                          ?,                                                               ?,                                                               ?,                                          ?,                                          ?,                                          ?,                                          ?,                                          ? )\n### Cause: com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Data too long for column \'is_deleted\' at row 1\n; Data truncation: Data too long for column \'is_deleted\' at row 1; nested exception is com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Data too long for column \'is_deleted\' at row 1', '2022-03-03 18:17:13');
INSERT INTO `sys_oper_log` VALUES (125, '仓库', 1, 'com.ruoyi.business.controller.WarehouseController.add()', 'POST', 1, 'admin', NULL, '/api/v2/business/warehouse', '127.0.0.1', '内网IP', '{\"modifiedName\":\"string\",\"address\":\"string\",\"keeper\":\"string\",\"remark\":\"string\",\"params\":{},\"createBy\":\"string\",\"isDeleted\":\"0\",\"createdBy\":0,\"updateBy\":\"string\",\"lessorusc\":\"string\",\"name\":\"string\",\"createdName\":\"string\",\"modifiedBy\":0,\"id\":\"string\",\"searchValue\":\"string\"}', NULL, 1, '\n### Error updating database.  Cause: java.sql.SQLIntegrityConstraintViolationException: Cannot add or update a child row: a foreign key constraint fails (`scaffold`.`warehouse`, CONSTRAINT `fk_warehouse_lessorUSC` FOREIGN KEY (`lessorUSC`) REFERENCES `lessor` (`usc`) ON DELETE RESTRICT ON UPDATE RESTRICT)\n### The error may exist in file [/Users/zhapeng/Documents/GitHub/RuoYi-Vue/ruoyi-business/target/classes/mapper/business/WarehouseMapper.xml]\n### The error may involve com.ruoyi.business.mapper.WarehouseMapper.insertWarehouse-Inline\n### The error occurred while setting parameters\n### SQL: insert into warehouse          ( id,                                          lessorUSC,                                          name,                                          Address,                                                               created_by,                                                               modified_by,                                          created_name,                                          modified_name,                                          is_deleted,                                          keeper,                                          remark )           values ( ?,                                          ?,                                          ?,                                          ?,                                                               ?,                                                               ?,                                          ?,                                          ?,                                          ?,                                          ?,                                          ? )\n### Cause: java.sql.SQLIntegrityConstraintViolationException: Cannot add or update a child row: a foreign key constraint fails (`scaffold`.`warehouse`, CONSTRAINT `fk_warehouse_lessorUSC` FOREIGN KEY (`lessorUSC`) REFERENCES `lessor` (`usc`) ON DELETE RESTRICT ON UPDATE RESTRICT)\n; Cannot add or up', '2022-03-03 18:17:41');
INSERT INTO `sys_oper_log` VALUES (126, '菜单管理', 3, 'com.ruoyi.web.controller.system.SysMenuController.remove()', 'DELETE', 1, 'admin', NULL, '/system/menu/4', '10.36.32.168', '内网IP', '{menuId=4}', '{\"msg\":\"菜单已分配,不允许删除\",\"code\":500}', 0, NULL, '2022-03-04 09:50:32');
INSERT INTO `sys_oper_log` VALUES (127, '角色管理', 2, 'com.ruoyi.web.controller.system.SysRoleController.edit()', 'PUT', 1, 'admin', NULL, '/system/role', '10.36.32.168', '内网IP', '{\"flag\":false,\"roleId\":2,\"admin\":false,\"remark\":\"普通角色\",\"dataScope\":\"2\",\"delFlag\":\"0\",\"params\":{},\"roleSort\":\"2\",\"deptCheckStrictly\":true,\"createTime\":1645753388000,\"updateBy\":\"admin\",\"menuCheckStrictly\":true,\"roleKey\":\"common\",\"roleName\":\"普通角色\",\"menuIds\":[3,1,100,1001,1002,1003,1004,1005,1006,1007,101,1008,1009,1010,1011,1012,102,1013,1014,1015,1016,103,1017,1018,1019,1020,104,1021,1022,1023,1024,1025,105,1026,1027,1028,1029,1030,106,1031,1032,1033,1034,1035,107,1036,1037,1038,1039,108,500,1040,1041,1042,501,1043,1044,1045,2,109,1046,1047,1048,110,1049,1050,1051,1052,1053,1054,111,112,113,114,115,1055,1056,1058,1057,1059,1060,116],\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-03-04 09:50:49');
INSERT INTO `sys_oper_log` VALUES (128, '菜单管理', 3, 'com.ruoyi.web.controller.system.SysMenuController.remove()', 'DELETE', 1, 'admin', NULL, '/system/menu/4', '10.36.32.168', '内网IP', '{menuId=4}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-03-04 09:51:07');
INSERT INTO `sys_oper_log` VALUES (129, '菜单管理', 2, 'com.ruoyi.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '10.36.32.168', '内网IP', '{\"visible\":\"0\",\"icon\":\"#\",\"orderNum\":1,\"menuName\":\"仓库管理\",\"params\":{},\"parentId\":2019,\"isCache\":\"0\",\"path\":\"warehouse\",\"component\":\"setting/warehouse/index\",\"children\":[],\"createTime\":1646292251000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":2020,\"menuType\":\"C\",\"perms\":\"setting:warehouse:list\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-03-04 10:20:26');
INSERT INTO `sys_oper_log` VALUES (130, '代码生成', 3, 'com.ruoyi.generator.controller.GenController.remove()', 'DELETE', 1, 'admin', NULL, '/tool/gen/4', '127.0.0.1', '内网IP', '{tableIds=4}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-03-04 10:56:04');
INSERT INTO `sys_oper_log` VALUES (131, '代码生成', 6, 'com.ruoyi.generator.controller.GenController.importTableSave()', 'POST', 1, 'admin', NULL, '/tool/gen/importTable', '127.0.0.1', '内网IP', 'lessor', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-03-04 10:56:24');
INSERT INTO `sys_oper_log` VALUES (132, '代码生成', 3, 'com.ruoyi.generator.controller.GenController.remove()', 'DELETE', 1, 'admin', NULL, '/tool/gen/5', '127.0.0.1', '内网IP', '{tableIds=5}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-03-04 10:56:30');
INSERT INTO `sys_oper_log` VALUES (133, '代码生成', 6, 'com.ruoyi.generator.controller.GenController.importTableSave()', 'POST', 1, 'admin', NULL, '/tool/gen/importTable', '127.0.0.1', '内网IP', 'lessee,lessor', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-03-04 10:56:47');
INSERT INTO `sys_oper_log` VALUES (134, '用户管理', 1, 'com.ruoyi.web.controller.system.SysUserController.add()', 'POST', 1, 'admin', NULL, '/system/user', '127.0.0.1', '内网IP', '{\"phonenumber\":\"13323233232\",\"admin\":false,\"password\":\"$2a$10$SLkkg/pQvFTB9xWPudtotufdLoZmrTonmutp1lJxnmKNru18NozCm\",\"postIds\":[2],\"email\":\"333@aa.com\",\"nickName\":\"yiyun\",\"sex\":\"0\",\"deptId\":100,\"params\":{},\"userName\":\"羿云\",\"userId\":100,\"createBy\":\"admin\",\"roleIds\":[2],\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-03-04 10:58:36');
INSERT INTO `sys_oper_log` VALUES (135, '菜单管理', 2, 'com.ruoyi.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '10.36.32.168', '内网IP', '{\"visible\":\"0\",\"icon\":\"redis\",\"orderNum\":1,\"menuName\":\"仓库管理\",\"params\":{},\"parentId\":2019,\"isCache\":\"0\",\"path\":\"warehouse\",\"component\":\"setting/warehouse/index\",\"children\":[],\"createTime\":1646292251000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":2020,\"menuType\":\"C\",\"perms\":\"setting:warehouse:list\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-03-04 11:55:43');
COMMIT;

-- ----------------------------
-- Table structure for sys_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post` (
                            `post_id` bigint NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
                            `post_code` varchar(64) NOT NULL COMMENT '岗位编码',
                            `post_name` varchar(50) NOT NULL COMMENT '岗位名称',
                            `post_sort` int NOT NULL COMMENT '显示顺序',
                            `status` char(1) NOT NULL COMMENT '状态（0正常 1停用）',
                            `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                            `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
                            `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                            `remark` varchar(500) DEFAULT NULL COMMENT '备注',
                            PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='岗位信息表';

-- ----------------------------
-- Records of sys_post
-- ----------------------------
BEGIN;
INSERT INTO `sys_post` VALUES (1, 'ceo', '董事长', 1, '0', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_post` VALUES (2, 'se', '项目经理', 2, '0', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_post` VALUES (3, 'hr', '人力资源', 3, '0', 'admin', '2022-02-25 09:43:08', '', NULL, '');
INSERT INTO `sys_post` VALUES (4, 'user', '普通员工', 4, '0', 'admin', '2022-02-25 09:43:08', '', NULL, '');
COMMIT;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
                            `role_id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色ID',
                            `role_name` varchar(30) NOT NULL COMMENT '角色名称',
                            `role_key` varchar(100) NOT NULL COMMENT '角色权限字符串',
                            `role_sort` int NOT NULL COMMENT '显示顺序',
                            `data_scope` char(1) DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
                            `menu_check_strictly` tinyint(1) DEFAULT '1' COMMENT '菜单树选择项是否关联显示',
                            `dept_check_strictly` tinyint(1) DEFAULT '1' COMMENT '部门树选择项是否关联显示',
                            `status` char(1) NOT NULL COMMENT '角色状态（0正常 1停用）',
                            `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
                            `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                            `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
                            `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                            `remark` varchar(500) DEFAULT NULL COMMENT '备注',
                            PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色信息表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES (1, '超级管理员', 'admin', 1, '1', 1, 1, '0', '0', 'admin', '2022-02-25 09:43:08', '', NULL, '超级管理员');
INSERT INTO `sys_role` VALUES (2, '普通角色', 'common', 2, '2', 1, 1, '0', '0', 'admin', '2022-02-25 09:43:08', 'admin', '2022-03-04 09:50:49', '普通角色');
COMMIT;

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept` (
                                 `role_id` bigint NOT NULL COMMENT '角色ID',
                                 `dept_id` bigint NOT NULL COMMENT '部门ID',
                                 PRIMARY KEY (`role_id`,`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色和部门关联表';

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_dept` VALUES (2, 100);
INSERT INTO `sys_role_dept` VALUES (2, 101);
INSERT INTO `sys_role_dept` VALUES (2, 105);
COMMIT;

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
                                 `role_id` bigint NOT NULL COMMENT '角色ID',
                                 `menu_id` bigint NOT NULL COMMENT '菜单ID',
                                 PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色和菜单关联表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_menu` VALUES (2, 1);
INSERT INTO `sys_role_menu` VALUES (2, 2);
INSERT INTO `sys_role_menu` VALUES (2, 3);
INSERT INTO `sys_role_menu` VALUES (2, 100);
INSERT INTO `sys_role_menu` VALUES (2, 101);
INSERT INTO `sys_role_menu` VALUES (2, 102);
INSERT INTO `sys_role_menu` VALUES (2, 103);
INSERT INTO `sys_role_menu` VALUES (2, 104);
INSERT INTO `sys_role_menu` VALUES (2, 105);
INSERT INTO `sys_role_menu` VALUES (2, 106);
INSERT INTO `sys_role_menu` VALUES (2, 107);
INSERT INTO `sys_role_menu` VALUES (2, 108);
INSERT INTO `sys_role_menu` VALUES (2, 109);
INSERT INTO `sys_role_menu` VALUES (2, 110);
INSERT INTO `sys_role_menu` VALUES (2, 111);
INSERT INTO `sys_role_menu` VALUES (2, 112);
INSERT INTO `sys_role_menu` VALUES (2, 113);
INSERT INTO `sys_role_menu` VALUES (2, 114);
INSERT INTO `sys_role_menu` VALUES (2, 115);
INSERT INTO `sys_role_menu` VALUES (2, 116);
INSERT INTO `sys_role_menu` VALUES (2, 500);
INSERT INTO `sys_role_menu` VALUES (2, 501);
INSERT INTO `sys_role_menu` VALUES (2, 1001);
INSERT INTO `sys_role_menu` VALUES (2, 1002);
INSERT INTO `sys_role_menu` VALUES (2, 1003);
INSERT INTO `sys_role_menu` VALUES (2, 1004);
INSERT INTO `sys_role_menu` VALUES (2, 1005);
INSERT INTO `sys_role_menu` VALUES (2, 1006);
INSERT INTO `sys_role_menu` VALUES (2, 1007);
INSERT INTO `sys_role_menu` VALUES (2, 1008);
INSERT INTO `sys_role_menu` VALUES (2, 1009);
INSERT INTO `sys_role_menu` VALUES (2, 1010);
INSERT INTO `sys_role_menu` VALUES (2, 1011);
INSERT INTO `sys_role_menu` VALUES (2, 1012);
INSERT INTO `sys_role_menu` VALUES (2, 1013);
INSERT INTO `sys_role_menu` VALUES (2, 1014);
INSERT INTO `sys_role_menu` VALUES (2, 1015);
INSERT INTO `sys_role_menu` VALUES (2, 1016);
INSERT INTO `sys_role_menu` VALUES (2, 1017);
INSERT INTO `sys_role_menu` VALUES (2, 1018);
INSERT INTO `sys_role_menu` VALUES (2, 1019);
INSERT INTO `sys_role_menu` VALUES (2, 1020);
INSERT INTO `sys_role_menu` VALUES (2, 1021);
INSERT INTO `sys_role_menu` VALUES (2, 1022);
INSERT INTO `sys_role_menu` VALUES (2, 1023);
INSERT INTO `sys_role_menu` VALUES (2, 1024);
INSERT INTO `sys_role_menu` VALUES (2, 1025);
INSERT INTO `sys_role_menu` VALUES (2, 1026);
INSERT INTO `sys_role_menu` VALUES (2, 1027);
INSERT INTO `sys_role_menu` VALUES (2, 1028);
INSERT INTO `sys_role_menu` VALUES (2, 1029);
INSERT INTO `sys_role_menu` VALUES (2, 1030);
INSERT INTO `sys_role_menu` VALUES (2, 1031);
INSERT INTO `sys_role_menu` VALUES (2, 1032);
INSERT INTO `sys_role_menu` VALUES (2, 1033);
INSERT INTO `sys_role_menu` VALUES (2, 1034);
INSERT INTO `sys_role_menu` VALUES (2, 1035);
INSERT INTO `sys_role_menu` VALUES (2, 1036);
INSERT INTO `sys_role_menu` VALUES (2, 1037);
INSERT INTO `sys_role_menu` VALUES (2, 1038);
INSERT INTO `sys_role_menu` VALUES (2, 1039);
INSERT INTO `sys_role_menu` VALUES (2, 1040);
INSERT INTO `sys_role_menu` VALUES (2, 1041);
INSERT INTO `sys_role_menu` VALUES (2, 1042);
INSERT INTO `sys_role_menu` VALUES (2, 1043);
INSERT INTO `sys_role_menu` VALUES (2, 1044);
INSERT INTO `sys_role_menu` VALUES (2, 1045);
INSERT INTO `sys_role_menu` VALUES (2, 1046);
INSERT INTO `sys_role_menu` VALUES (2, 1047);
INSERT INTO `sys_role_menu` VALUES (2, 1048);
INSERT INTO `sys_role_menu` VALUES (2, 1049);
INSERT INTO `sys_role_menu` VALUES (2, 1050);
INSERT INTO `sys_role_menu` VALUES (2, 1051);
INSERT INTO `sys_role_menu` VALUES (2, 1052);
INSERT INTO `sys_role_menu` VALUES (2, 1053);
INSERT INTO `sys_role_menu` VALUES (2, 1054);
INSERT INTO `sys_role_menu` VALUES (2, 1055);
INSERT INTO `sys_role_menu` VALUES (2, 1056);
INSERT INTO `sys_role_menu` VALUES (2, 1057);
INSERT INTO `sys_role_menu` VALUES (2, 1058);
INSERT INTO `sys_role_menu` VALUES (2, 1059);
INSERT INTO `sys_role_menu` VALUES (2, 1060);
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
                            `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID',
                            `dept_id` bigint DEFAULT NULL COMMENT '部门ID',
                            `user_name` varchar(30) NOT NULL COMMENT '用户账号',
                            `nick_name` varchar(30) NOT NULL COMMENT '用户昵称',
                            `user_type` varchar(2) DEFAULT '00' COMMENT '用户类型（00系统用户）',
                            `email` varchar(50) DEFAULT '' COMMENT '用户邮箱',
                            `phonenumber` varchar(11) DEFAULT '' COMMENT '手机号码',
                            `sex` char(1) DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
                            `avatar` varchar(100) DEFAULT '' COMMENT '头像地址',
                            `password` varchar(100) DEFAULT '' COMMENT '密码',
                            `status` char(1) DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
                            `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
                            `login_ip` varchar(128) DEFAULT '' COMMENT '最后登录IP',
                            `login_date` datetime DEFAULT NULL COMMENT '最后登录时间',
                            `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                            `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
                            `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                            `remark` varchar(500) DEFAULT NULL COMMENT '备注',
                            PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户信息表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES (1, 103, 'admin', '若依', '00', 'ry@163.com', '15888888888', '1', '', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '10.36.32.168', '2022-03-04 09:50:00', 'admin', '2022-02-25 09:43:08', '', '2022-03-04 09:49:59', '管理员');
INSERT INTO `sys_user` VALUES (2, 105, 'ry', '若依', '00', 'ry@qq.com', '15666666666', '1', '', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', '2022-02-25 09:43:08', 'admin', '2022-02-25 09:43:08', '', NULL, '测试员');
INSERT INTO `sys_user` VALUES (100, 100, '羿云', 'yiyun', '00', '333@aa.com', '13323233232', '0', '', '$2a$10$SLkkg/pQvFTB9xWPudtotufdLoZmrTonmutp1lJxnmKNru18NozCm', '0', '0', '', NULL, 'admin', '2022-03-04 10:58:36', '', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_user_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_post`;
CREATE TABLE `sys_user_post` (
                                 `user_id` bigint NOT NULL COMMENT '用户ID',
                                 `post_id` bigint NOT NULL COMMENT '岗位ID',
                                 PRIMARY KEY (`user_id`,`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户与岗位关联表';

-- ----------------------------
-- Records of sys_user_post
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_post` VALUES (1, 1);
INSERT INTO `sys_user_post` VALUES (2, 2);
INSERT INTO `sys_user_post` VALUES (100, 2);
COMMIT;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
                                 `user_id` bigint NOT NULL COMMENT '用户ID',
                                 `role_id` bigint NOT NULL COMMENT '角色ID',
                                 PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户和角色关联表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (2, 2);
INSERT INTO `sys_user_role` VALUES (100, 2);
COMMIT;

-- ----------------------------
-- Table structure for warehouse
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse` (
                             `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id作为主键',
                             `lessorUSC` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '租赁公司统一社会信用代码',
                             `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '仓库名称',
                             `Address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '仓库地址',
                             `keeper` varchar(10) DEFAULT NULL COMMENT '仓库管理员',
                             `remark` varchar(255) DEFAULT NULL COMMENT '备注',
                             `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                             `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                             `update_by` varchar(64) DEFAULT '' COMMENT '更新至',
                             `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                             `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除0:未删除;1:删除',
                             PRIMARY KEY (`id`) USING BTREE,
                             KEY `fk_warehouse_lessorUSC` (`lessorUSC`) USING BTREE,
                             CONSTRAINT `fk_warehouse_lessorUSC` FOREIGN KEY (`lessorUSC`) REFERENCES `lessor` (`usc`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='仓库表，一个租赁公司可以有多个仓库';

-- ----------------------------
-- Records of warehouse
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
