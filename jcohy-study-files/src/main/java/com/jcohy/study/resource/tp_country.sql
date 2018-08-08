/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50637
Source Host           : localhost:3306
Source Database       : terminal_operation

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2018-08-08 14:28:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tp_country
-- ----------------------------
DROP TABLE IF EXISTS `tp_country`;
CREATE TABLE `tp_country` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `country_name_en` varchar(100) NOT NULL COMMENT '国家名称_英语|jiac|20180511',
  `country_name` varchar(50) NOT NULL COMMENT '国家名称|jiac|20180511',
  `country_no` varchar(50) DEFAULT NULL COMMENT '国家编码|jiac|20180511',
  `phone_number` int(20) DEFAULT NULL,
  `gmt` varchar(255) DEFAULT NULL,
  `currency_name` varchar(100) DEFAULT NULL,
  `currency_code` varchar(50) DEFAULT NULL,
  `currency_symbol` varchar(50) DEFAULT NULL,
  `continent_id` bigint(20) DEFAULT NULL COMMENT '所在洲Id|jiac|20180511',
  `dvb_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态1.使用|jiac|20180511',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已删除|jiac|20180511',
  `deleted_time` datetime DEFAULT NULL COMMENT '删除时间|jiac|20180511',
  `created_by` bigint(20) NOT NULL COMMENT '创建者|jiac|20180511',
  `created_time` datetime NOT NULL COMMENT '创建时间|jiac|20180511',
  `updated_by` bigint(20) NOT NULL COMMENT '修改者|jiac|20180511',
  `updated_time` datetime NOT NULL COMMENT '修改时间|jiac|20180511',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_22` (`continent_id`),
  KEY `Index_1_country_name` (`country_name`) USING BTREE,
  CONSTRAINT `FK_Reference_22` FOREIGN KEY (`continent_id`) REFERENCES `tp_continent` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=195 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_country
-- ----------------------------
INSERT INTO `tp_country` VALUES ('1', 'Angola', '安哥拉', 'AGO', '244', 'GMT+1:00', '安哥拉匡撒', 'AOA', 'Kz', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('2', 'Afghanistan', '阿富汗', 'AFG', '93', 'GMT+8:00', '阿富汗尼', 'Af', 'Af', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('3', 'Albania', '阿尔巴尼亚', 'ALB', '355', 'GMT+1:00', '列克', 'Lek', 'Lek', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('4', 'Algeria', '阿尔及利亚', 'DZA', '213', 'GMT+0:00', '阿尔及利亚第纳尔', 'DZD', 'دج', '1', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('5', 'Andorra', '安道尔共和国', 'AND', '376', 'GMT+0:00', '欧元', 'EUR', '€', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('6', 'Anguilla', '安圭拉岛', 'AIA', '1264', 'GMT-4:00', '东加勒比元', 'XCD', '$', '5', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('7', 'Antigua and Barbuda', '安提瓜和巴布达', 'ATG', '1268', 'GMT-4:00', '东加勒比元', 'XCD', '$', '5', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('8', 'Argentina', '阿根廷', 'ARG', '54', 'GMT-3:00', '阿根廷比索', 'ARS', '$', '4', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('9', 'Armenia', '亚美尼亚', 'ARM', '374', 'GMT+2:00', '亚美尼亚德拉姆', 'AMD', 'Դ', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('10', 'Ascension', '阿森松', 'AC', '247', 'GMT+0:00', '圣赫勒拿镑', '英镑', '£', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('11', 'Australia', '澳大利亚', 'AUS', '61', 'GMT+10:00', '澳元', 'AUD', '$, A$, AU$', '6', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('12', 'Austria', '奥地利', 'AUT', '43', 'GMT+1:00', '欧元', 'EUR', '€', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('13', 'Azerbaijan', '阿塞拜疆', 'AZE', '994', 'GMT+3:00', '阿塞拜疆马纳特', 'AZN', 'man.', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('14', 'Bahamas', '巴哈马', 'BHS', '1242', 'GMT-5:00', '巴哈马元', 'BSD', 'B$', '5', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('15', 'Bahrain', '巴林', 'BHR', '973', 'GMT+3:00', '巴林第納爾', 'BHD', '.د.ب', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('16', 'Bangladesh', '孟加拉国', 'BGD', '880', 'GMT+6:00', '孟加拉塔卡', 'BDT', 'Tk', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('17', 'Barbados', '巴巴多斯', 'BRB', '1246', 'GMT-4:00', '巴巴多斯元', 'BBD', 'Bds$', '5', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('18', 'Belarus', '白俄罗斯', 'BLR', '375', 'GMT+2:00', '白俄罗斯卢布', 'BYN', 'р', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('19', 'Belgium', '比利时', 'BEL', '32', 'GMT+1:00', '欧元', 'EUR', '€', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('20', 'Belize', '伯利兹', 'BLZ', '501', 'GMT-6:00', '伯利兹元', 'BZD', 'BZ$', '5', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('21', 'Benin', '贝宁', 'BEN', '229', 'GMT+1:00', '西非法郎', 'XOF', 'BCEAO', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('22', 'Bermuda Is.', '百慕大群岛', 'BMU', '1441', 'GMT-4:00', '百慕達元', 'BMD', 'BD$', '5', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('23', 'Bolivia', '玻利维亚', 'BOL', '591', 'GMT-4:00', '玻利维亚诺', 'BOB', 'Bs', '4', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('24', 'Botswana', '博茨瓦纳', 'BWA', '267', 'GMT+2:00', '博茨瓦纳普拉', 'BWP', 'P', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('25', 'Brazil', '巴西', 'BRA', '55', 'GMT-3:00', '巴西雷亚尔', 'BRL', 'R$', '4', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('26', 'Brunei', '文莱', 'BRN', '673', 'GMT+8:00', '文莱元', 'BND', 'B$', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('27', 'Bulgaria', '保加利亚', 'BGR', '359', 'GMT+2:00', '保加利亞列弗', 'BGN', 'лв', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('28', 'Burkina-faso', '布基纳法索', 'BFA', '226', 'GMT+0:00', '西非法郎', 'XOF', 'BCEAO', '1', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('29', 'Burma', '缅甸', 'MM', '95', 'GMT+6:70', '缅元', 'MMK', 'K', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('30', 'Burundi', '布隆迪', 'BDI', '257', 'GMT+2:00', '布隆迪法郎', 'BIF', 'FBu', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('31', 'Cameroon', '喀麦隆', 'CMR', '237', 'GMT+1:00', '中非法郎', 'XAF', 'BCEA', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('32', 'Canada', '加拿大', 'CAN', '1', 'GMT-5:00', '加元', 'CAD', '$, C$', '5', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('33', 'Cayman Is.', '开曼群岛', 'CYM', '1345', 'GMT-5:00', '开曼群岛元', 'KYD', '$', '5', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('34', 'Central African Republic', '中非共和国', 'CAF', '236', 'GMT+1:00', '中非法郎', 'XAF', 'BEAC', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('35', 'Chad', '乍得', 'TCD', '235', 'GMT+1:00', '中非法郎', 'XAF', 'BEAC', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('36', 'Chile', '智利', 'CHL', '56', 'GMT-5:00', '智利比索', 'CLP', '$', '4', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('37', 'China', '中国', 'CHN', '86', 'GMT+8:00', '人民币', 'CNY', '¥', '2', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('38', 'Colombia', '哥伦比亚', 'COL', '57', 'GMT+8:00', '哥伦比亚比索', 'COP', '$', '5', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('39', 'Democratic Republic of the Congo', '刚果金', 'COD', '243', 'GMT+1:00', '刚果法郎', 'CDF', '₣', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('40', 'Cook Is.', '库克群岛', 'COK', '682', 'GMT-10:30', '库克群岛元', 'NZD', '$', '6', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('41', 'Costa Rica', '哥斯达黎加', 'CRI', '506', 'GMT-6:00', '哥斯达黎加科朗', 'CRC', '₡', '5', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('42', 'Cuba', '古巴', 'CUB', '53', 'GMT-5:00', '古巴比索', 'CUP', '$MN', '5', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('43', 'Cyprus', '塞浦路斯', 'CYP', '357', 'GMT+2:00', '欧元', 'EUR', '€', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('44', 'Czech Republic', '捷克', 'CZE', '420', 'GMT+1:00', '捷克克朗', 'CZK', 'Kč', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('45', 'Denmark', '丹麦', 'DNK', '45', 'GMT+1:00', '丹麦克朗', 'DKK', 'kr', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('46', 'Djibouti', '吉布提', 'DJI', '253', 'GMT+3:00', '吉布提法郎', 'DJF', 'Fdj', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('47', 'Dominica Rep.', '多米尼加共和国', 'DOM', '1890', 'GMT-5:00', '多米尼加比索', 'DOP', 'RD$', '5', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('48', 'Ecuador', '厄瓜多尔', 'ECU', '593', 'GMT-5:00', '美元', 'USD', '$', '4', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('49', 'Egypt', '埃及', 'EGY', '20', 'GMT+2:00', '埃及镑', 'EGP', 'ج.م', '1', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('50', 'Equatorial Guinea', '赤道几内亚', 'GNQ', '240', 'GMT+1:00', '中非法郎', 'XAF', 'BEAC', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('51', 'Eritrea', '厄立特里亚', 'ERI', '291', 'GMT+3:00', '中非法郎', 'XAF', 'BEAC', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('52', 'EI Salvador', '萨尔瓦多', 'SLV', '503', 'GMT-6:00', '萨尔瓦多克朗', 'SVC', '₡', '5', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('53', 'Estonia', '爱沙尼亚', 'EST', '372', 'GMT+3:00', '欧元', 'EUR', '€', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('54', 'Ethiopia', '埃塞俄比亚', 'ETH', '251', 'GMT+3:00', '埃塞俄比亚比尔', 'ETB', 'Br', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('55', 'Fiji', '斐济', 'FJI', '679', 'GMT+12:00', '斐济元', 'FJD', 'FJ$', '6', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('56', 'Finland', '芬兰', 'FIN', '358', 'GMT+2:00', '欧元', 'EUR', '€', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('57', 'France', '法国', 'FRA', '33', 'GMT+0:00', '欧元', 'EUR', '€', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('58', 'French Guiana', '法属圭亚那', 'GUF', '594', 'GMT-4:00', '欧元', 'EUR', '€', '4', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('59', 'Gabon', '加蓬', 'GAB', '241', 'GMT+1:00', '中非法郎', 'XAF', 'BEAC', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('60', 'Gambia', '冈比亚', 'GMB', '220', 'GMT+0:00', '达拉西', 'GMD', 'D', '1', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('61', 'Georgia', '格鲁吉亚', 'GEO', '995', 'GMT+8:00', '格鲁吉亚拉里', 'GEL', '₾', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('62', 'Germany', '德国', 'DEU', '49', 'GMT+1:00', '欧元', 'EUR', '€', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('63', 'Ghana', '加纳', 'GHA', '233', 'GMT+0:00', '塞地', 'GHS', 'GHS', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('64', 'Gibraltar', '直布罗陀', 'GIB', '350', 'GMT+0:00', '直布罗陀镑', 'GIP', '£', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('65', 'Greece', '希腊', 'GRC', '30', 'GMT+2:00', '欧元', 'EUR', '€', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('66', 'Grenada', '格林纳达', 'GRD', '1809', 'GMT-6:00', '东加勒比元', 'XCD', 'EC$', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('67', 'Guam', '关岛', 'GUM', '1671', 'GMT+10:00', '美元', 'USD', '$', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('68', 'Guatemala', '危地马拉', 'GTM', '502', 'GMT-6:00', '危地马拉格查尔 ', 'GTQ', 'Q', '5', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('69', 'Guinea', '几内亚', 'GIN', '224', 'GMT+0:00', '几内亚法郎', 'GNF', 'FG', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('70', 'Guinea-Bissau', '几内亚比绍共和国', 'GNB', '245', 'GMT+0:00', '几内亚法郎', 'GNF', 'FG', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('71', 'Guyana', '圭亚那', 'GUY', '592', 'GMT-3:00', '圭亚那元（', 'GYD', 'GY$', '4', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('72', 'Haiti', '海地', 'HTI', '509', 'GMT-5:00', '海地古德', 'HTG', '₾', '5', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('73', 'Honduras', '洪都拉斯', 'HND', '504', 'GMT-6:00', '倫皮拉', 'HNL', 'L', '5', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('74', 'Hongkong', '香港', 'HKG', '852', 'GMT+8:00', '港元', 'HKD', '$, HK$', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('75', 'Hungary', '匈牙利', 'HUN', '36', 'GMT+1:00', '匈牙利福林', 'HUF', 'Ft', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('76', 'Iceland', '冰岛', 'ISL', '354', 'GMT-1:00', '冰岛克朗', 'ISK', 'kr', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('77', 'India', '印度', 'IND', '91', 'GMT+5:70', '印度卢比', 'INR', 'Rs.', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('78', 'Indonesia', '印度尼西亚', 'IDN', '62', 'GMT+7:70', '印尼盾', 'IDR', 'Rp', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('79', 'Iran', '伊朗', 'IRN', '98', 'GMT+3:70', '伊朗里亚尔', 'IRR', 'ریال', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('80', 'Iraq', '伊拉克', 'IRQ', '964', 'GMT+3:00', '伊拉克第纳尔', 'IQD', 'ع.د', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('81', 'Ireland', '爱尔兰', 'IRL', '353', 'GMT+3:70', '欧元', 'EUR', '€', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('82', 'Israel', '以色列', 'ISR', '972', 'GMT+2:00', '以色列新谢克尔', 'ILS', '₪', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('83', 'Italy', '意大利', 'ITA', '39', 'GMT+1:00', '欧元', 'EUR', '€', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('84', 'Ivory Coast', '科特迪瓦', 'CIV', '225', 'GMT+2:00', '西非法郎', 'XOF', 'BCEAO', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('85', 'Jamaica', '牙买加', 'JAM', '1876', 'GMT-4:00', '牙买加元', 'JMD', '$', '5', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('86', 'Japan', '日本', 'JPN', '81', 'GMT+9:00', '日元', 'JPY', '¥', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('87', 'Jordan', '约旦', 'JOR', '962', 'GMT+2:00', '約旦第納爾', 'JOD', 'JOD', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('88', 'Kampuchea (Cambodia )', '柬埔寨', 'KH', '855', 'GMT+7:00', '瑞尔', 'KHR', 'KHR', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('89', 'Kazakstan', '哈萨克斯坦', 'KAZ', '327', 'GMT+3:00', '哈萨克斯坦坚戈', 'KZT', 'KZT', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('90', 'Kenya', '肯尼亚', 'KEN', '254', 'GMT+3:00', '先令', 'KES', 'KSh', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('91', 'Korea', '韩国', 'PRK', '82', 'GMT+9:00', '韩元', 'KRW', '₩', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('92', 'Kuwait', '科威特', 'KWT', '965', 'GMT+3:00', '科威特第納爾', 'KWD', 'د.ك', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('93', 'Kyrgyzstan', '吉尔吉斯坦', 'KGZ', '331', 'GMT+3:00', '吉尔吉斯斯坦索姆', 'KGS', 'KGS', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('94', 'Laos', '老挝', 'LAO', '856', 'GMT+7:00', '老挝吉普', 'LAK', '₭', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('95', 'Latvia', '拉脱维亚', 'LVA', '371', 'GMT+3:00', '欧元', 'EUR', '€', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('96', 'Lebanon', '黎巴嫩', 'LBN', '961', 'GMT+2:00', '黎巴嫩鎊', 'LBP', 'ل.ل', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('97', 'Lesotho', '莱索托', 'LSO', '266', 'GMT+2:00', '莱索托洛蒂', 'LSL', 'L', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('98', 'Liberia', '利比里亚', 'LBR', '231', 'GMT+0:00', '利比里亚元', 'LRD', 'L$', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('99', 'Libya', '利比亚', 'LBY', '218', 'GMT+2:00', '第纳尔', 'LYD', 'LD', '1', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('100', 'Liechtenstein', '列支敦士登', 'LIE', '423', 'GMT+1:00', '法郎', 'CHF', 'Fr., SFr, FS', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('101', 'Lithuania', '立陶宛', 'LTU', '370', 'GMT+3:00', '欧元', 'EUR', '€', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('102', 'Luxembourg', '卢森堡', 'LUX', '352', 'GMT+1:00', '欧元', 'EUR', '€', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('103', 'Macao', '澳门', 'MAC', '853', 'GMT+8:00', '澳门币', 'MOP', '$', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('104', 'Madagascar', '马达加斯加', 'MDG', '261', 'GMT+3:00', '马达加斯加阿里亚里', 'MGA', 'Ar', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('105', 'Malawi', '马拉维', 'MWI', '265', 'GMT+2:00', '马拉维克瓦查', 'MWK', 'MK', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('106', 'Malaysia', '马来西亚', 'MYS', '60', 'GMT+7:50', '令吉', 'MYR', 'RM', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('107', 'Maldives', '马尔代夫', 'MDV', '960', 'GMT+1:00', '拉菲亞', 'MVR', 'Rf', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('108', 'Mali', '马里', 'MLI', '223', 'GMT+0:00', '西非法郎', 'CHF', 'Fr., SFr, FS', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('109', 'Malta', '马耳他', 'MLT', '356', 'GMT+1:00', '欧元', 'EUR', '€', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('110', 'Mariana Is', '马里亚那群岛', 'MHL', '1670', 'GMT+9:00', '美元', 'USD', '$', '6', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('111', 'Martinique', '马提尼克', 'MTQ', '596', 'GMT-4:00', '欧元', 'EUR', '€', '5', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('112', 'Mauritius', '毛里求斯', 'MUS', '230', 'GMT+4:00', '毛里求斯卢比', 'MUR', '₨', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('113', 'Mexico', '墨西哥', 'MEX', '52', 'GMT-7:00', '墨西哥比索', 'MXN', '$, Mex$', '5', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('114', 'Moldova, Republic of', '摩尔多瓦', 'MDA', '373', 'GMT+3:00', '列伊', 'MDL', 'MDL', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('115', 'Monaco', '摩纳哥', 'MCO', '377', 'GMT+1:00', '欧元', 'EUR', '€', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('116', 'Mongolia', '蒙古', 'MNG', '976', 'GMT+8:00', '蒙古图格里克', 'MNT', '₮', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('117', 'Montserrat Is', '蒙特塞拉特岛', 'MSR', '1664', 'GMT-4:00', '东加勒比元', 'xcd', 'EC$', '5', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('118', 'Morocco', '摩洛哥', 'MAR', '212', 'GMT+2:00', '摩洛哥迪尔汗', 'MAD', 'د.م.', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('119', 'Mozambique', '莫桑比克', 'MOZ', '258', 'GMT+2:00', '莫桑比克梅蒂卡尔', 'MZN', 'MT', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('120', 'Namibia', '纳米比亚', 'NAM', '264', 'GMT+1:00', '纳米比亚元', 'NAD', 'N$', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('121', 'Nauru', '瑙鲁', 'NRU', '674', 'GMT+12:00', '澳洲元', 'AUD', '$, A$, AU$', '6', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('122', 'Nepal', '尼泊尔', 'NPL', '977', 'GMT+5:70', '尼泊尔卢比', 'NPR', '₨', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('123', 'Netheriands Antilles', '荷属安的列斯', 'NA', '599', 'GMT-4:00', '荷屬安的列斯盾', 'ANG', 'NAƒ', '6', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('124', 'Netherlands', '荷兰', 'NLD', '31', 'GMT+1:00', '欧元', 'EUR', '€', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('125', 'New Zealand', '新西兰', 'NZL', '64', 'GMT+12:00', '新西兰元', 'NZD', '$, NZ$', '6', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('126', 'Nicaragua', '尼加拉瓜', 'NIC', '505', 'GMT-6:00', '尼加拉瓜科多巴', 'NIO', 'C$', '5', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('127', 'Niger', '尼日尔', 'NER', '227', 'GMT+0:00', '西非法郎', 'XOF', 'BCEAO', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('128', 'Nigeria', '尼日利亚', 'NGA', '234', 'GMT+1:00', '尼日利亚奈拉', 'NGN', '₦', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('129', 'North Korea', '朝鲜', 'KP', '850', 'GMT+9:00', '朝鲜元', 'KPW', '₩', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('130', 'Norway', '挪威', 'NOR', '47', 'GMT+1:00', '挪威克朗', 'NOK', 'kr', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('131', 'Oman', '阿曼', 'OMN', '968', 'GMT+4:00', '里亚尔', 'OMR', 'OMR', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('132', 'Pakistan', '巴基斯坦', 'PAK', '92', 'GMT+5:70', '巴基斯坦卢布', 'PKR', 'Rs.', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('133', 'Panama', '巴拿马', 'PAN', '507', 'GMT-5:00', '巴波亞', 'PAB', 'B', '5', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('134', 'Papua New Cuinea', '巴布亚新几内亚', 'PNG', '675', 'GMT+10:00', '基那', 'PGK', 'K', '6', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('135', 'Paraguay', '巴拉圭', 'PRY', '595', 'GMT-4:00', '巴拉圭瓜拉尼', 'PYG', 'PYG', '4', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('136', 'Peru', '秘鲁', 'PER', '51', 'GMT-5:00', '新索爾', 'PEN', 'S/.', '4', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('137', 'Philippines', '菲律宾', 'PHL', '63', 'GMT+8:00', '披索', 'PHP', '₱', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('138', 'Poland', '波兰', 'POL', '48', 'GMT+1:00', '波兰兹罗提', 'PLN', 'zł', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('139', 'French Polynesia', '法属玻利尼西亚', 'PF', '689', 'GMT+11:00', '法郎', 'XAF', 'BEAC', '6', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('140', 'Portugal', '葡萄牙', 'PRT', '351', 'GMT+0:00', '欧元', 'EUR', '€', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('141', 'Puerto Rico', '波多黎各', 'PRI', '1787', 'GMT-4:00', '美元', 'USD', '$', '5', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('142', 'Qatar', '卡塔尔', 'QAT', '974', 'GMT+3:00', '里亚尔', 'QAR', 'ر.ق', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('143', 'Romania', '罗马尼亚', 'ROU', '40', 'GMT+2:00', '罗马尼亚列伊', 'RON', 'L', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('144', 'Russia', '俄罗斯', 'RUS', '7', 'GMT+3:00', '卢布', 'RUB', '₽', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('145', 'Republic of the Congo', '刚果布', 'COG', '242', 'GMT+1:00', '法郎', 'XAF', 'BEAC', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('146', 'Rwanda', '卢旺达', 'RWA', '250', 'GMT+2:00', '卢旺达法郎', 'RWF', 'RF', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('147', 'St.Lucia', '圣卢西亚', 'LCA', '1758', 'GMT-4:00', '东加勒比元', 'XCD', 'EC$', '5', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('148', 'Samoa Eastern', '东萨摩亚(美)', 'AS', '684', 'GMT-11:00', '萨摩亚塔拉', 'EST', 'ES$', '5', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('149', 'Samoa Western', '西萨摩亚', 'WSM', '685', 'GMT-11:00', '萨摩亚塔拉', 'WST', 'WS$', '6', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('150', 'San Marino', '圣马力诺', 'SMR', '378', 'GMT+1:00', '欧元', 'EUR', '€', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('151', 'Sao Tome and Principe', '圣多美和普林西比', 'STP', '239', 'GMT+0:00', '圣多美和普林西比多布拉', 'STD', 'Db', '1', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('152', 'Saudi Arabia', '沙特阿拉伯', 'SAU', '966', 'GMT+3:00', '沙特阿拉伯里亚尔', 'SAR', 'ر.س', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('153', 'Senegal', '塞内加尔', 'SEN', '221', 'GMT+0:00', '西非法郎', 'xof', 'BCEAO', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('154', 'Seychelles', '塞舌尔', 'SYC', '248', 'GMT+4:00', '塞舌尔卢比', 'SCR', 'SR', '1', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('155', 'Sierra Leone', '塞拉利昂', 'SLE', '232', 'GMT+0:00', '塞拉利昂利昂', 'SLL', 'Le', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('156', 'Singapore', '新加坡', 'SGP', '65', 'GMT+8:30', '新加坡元', 'SGD', '$, S$', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('157', 'Slovakia', '斯洛伐克', 'SVK', '421', 'GMT+1:00', '欧元', 'EUR', '€', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('158', 'Slovenia', '斯洛文尼亚', 'SVN', '386', 'GMT+1:00', '欧元', 'EUR', '€', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('159', 'Solomon Is', '所罗门群岛', 'SLB', '677', 'GMT+11:00', '所罗门群岛元', 'SBD', 'SI$', '6', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('160', 'Somali', '索马里', 'SOM', '252', 'GMT+3:00', '索马里先令', 'SOS', 'So.', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('161', 'South Africa', '南非', 'ZAF', '27', 'GMT+2:00', '南非兰特', 'ZAR', 'R', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('162', 'Spain', '西班牙', 'ESP', '34', 'GMT+0:00', 'EUR', '€', '欧洲', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('163', 'Sri Lanka', '斯里兰卡', 'LKA', '94', 'GMT+8:00', '斯里兰卡卢布', 'LKR', 'ரூ', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('164', 'Comores', '科摩罗', 'KML', '269', 'GMT+3:00', '科摩罗法郎', 'KMF', 'Fr.', '1', '1', '0', null, '1', '2018-07-26 13:26:49', '1', '2018-07-26 13:26:55');
INSERT INTO `tp_country` VALUES ('165', 'St.Vincent', '圣文森特', 'VC', '1784', 'GMT-4:00', '东加勒比元', 'XCD', 'EC$', '5', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('166', 'South Sudan', '南苏丹共和国', 'DSN', '211', 'GMT+3:00', '南苏丹镑', 'SSP', 'SSP', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('167', 'Sudan', '苏丹', 'SDN', '249', 'GMT+2:00', '苏丹镑', 'SDG', 'SDG', '1', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('168', 'Suriname', '苏里南', 'SUR', '597', 'GMT-3:30', '苏里南元', 'SRD', '$', '4', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('169', 'Swaziland', '斯威士兰', 'SWZ', '268', 'GMT+2:00', '斯威士兰里兰吉尼', 'SZL', 'SZL', '1', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('170', 'Sweden', '瑞典', 'SWE', '46', 'GMT+1:00', '瑞典克朗', 'SEK', 'kr', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('171', 'Switzerland', '瑞士', 'CHE', '41', 'GMT+1:00', '瑞士法郎', 'CHF', 'Fr., SFr, FS', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('172', 'Syria', '叙利亚', 'SYR', '963', 'GMT+2:00', '叙利亚镑', 'SYP', 'SYP', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('173', 'Taiwan', '台湾省', 'TWN', '886', 'GMT+8:00', '新台币', 'TWD', 'NT$', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('174', 'Tajikstan', '塔吉克斯坦', 'TJK', '992', 'GMT+3:00', '塔吉克斯坦索莫尼', 'TJS', 'с.', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('175', 'Tanzania', '坦桑尼亚', 'TZA', '255', 'GMT+3:00', '坦桑尼亚先令', 'TZS', 'x', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('176', 'Thailand', '泰国', 'THA', '66', 'GMT+7:00', '泰铢', 'THB', '฿', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('177', 'Togo', '多哥', 'TGO', '228', 'GMT+0:00', '西非法郎', 'XOF', 'BCEAO', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('178', 'Tonga', '汤加', 'TON', '676', 'GMT+13:00', '汤加潘加', 'TOP', 'T$', '6', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('179', 'Trinidad and Tobago', '特立尼达和多巴哥', 'TTO', '1809', 'GMT-4:00', '特立尼达和多巴哥元', 'TTD', 'TTD', '5', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('180', 'Tunisia', '突尼斯', 'TUN', '216', 'GMT+1:00', '突尼斯第纳尔', 'TND', 'د.ت', '1', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('181', 'Turkey', '土耳其', 'TUR', '90', 'GMT+2:00', '土耳其新里拉', 'TRY', 'YTL', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('182', 'Turkmenistan', '土库曼斯坦', 'TKM', '993', 'GMT+3:00', '土库曼斯坦马纳特', 'TMT', 'T', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('183', 'Uganda', '乌干达', 'UGA', '256', 'GMT+3:00', '乌干达先令', 'UGX', 'USh', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('184', 'Ukraine', '乌克兰', 'UKR', '380', 'GMT+3:00', '乌克兰格里夫纳', 'UAH', '₴', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('185', 'United Arab Emirates', '阿拉伯联合酋长国', 'ARE', '971', 'GMT+4:00', '阿联酋迪拉姆', 'AED', 'د.إ', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('186', 'United Kiongdom', '英国', 'GBR', '44', 'GMT+0:00', '英镑', 'GBP', '£', '3', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('187', 'United States of America', '美国', 'USA', '1', 'GMT-5:00', '美元', 'USD', '$', '5', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('188', 'Uruguay', '乌拉圭', 'URY', '598', 'GMT-2:30', '比索', 'UYU', 'UYU', '4', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('189', 'Uzbekistan', '乌兹别克斯坦', 'UZB', '233', 'GMT+3:00', '乌兹别克斯坦索姆', 'UZS', 'UZS', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('190', 'Venezuela', '委内瑞拉', 'VEN', '58', 'GMT-4:30', '玻利瓦爾', 'VEF', 'VEF', '4', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('191', 'Vietnam', '越南', 'VNM', '84', 'GMT+7:00', '越南盾', 'VND', '₫', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('192', 'Yemen', '也门', 'YEM', '967', 'GMT+3:00', '也门里亚尔', 'YER', 'YER', '2', '0', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('193', 'Zimbabwe', '津巴布韦', 'ZWE', '263', 'GMT+2:00', '津巴布韦元', 'ZWL', '$', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
INSERT INTO `tp_country` VALUES ('194', 'Zambia', '赞比亚', 'ZMB', '260', 'GMT+2:00', '赞比亚克瓦查', 'ZMW', 'ZK', '1', '1', '0', null, '1', '2017-08-08 00:00:00', '1', '2017-08-08 16:00:00');
