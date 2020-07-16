package generator;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.File;
import java.util.*;

/**
 * Author by Tim 2019-04-01
 */
// 执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class CodeGenerator {

	private static String dbUrl = "jdbc:mysql://112.74.52.237:3306/wx-subscription-account?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
	private static String dbUserName = "root";
	private static String dbUserPassword = "root";
	private static String dbDriverClass = "com.mysql.jdbc.Driver";
/*	private static String dbUrl = "jdbc:sqlserver://125.88.171.83:1433;DatabaseName=ASK3";
	private static String dbUserName = "fddoctorj1olslgo";
	private static String dbUserPassword = "#5fgh8dfjh#sTYdfg8%%8@56%##";
	private static String dbDriverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";*/

	// 要生成的表名，表名多个表','隔开，全部则空，{}
	//CooperationQuoteS  DrugPrices   ArticleAssociate  Medicine_Drugstore_Price Medicine_DrugPrices
	//  Associates  Factory    YPK_Efficacy DrugCategories
	//private static String[] tables = new String[] {"CooperationQuoteS","DrugPrices","ArticleAssociate",
			//"Medicine_Drugstore_Price","Medicine_DrugPrices","Associates","Factory","YPK_Efficacy","DrugCategories"};
	private static String[] tables = new String[] {"wx_cron"};
	// table前缀
	private static String[] prefixs = new String[] {};
	// 包名，运行前修改与项目的包名一致
	private static String xxx = "wxentrance";
	private static String pageName = "wx";
	private static String packageName = "cn.wx.mzpro." + xxx;
	private static final String daoModuleRootPackage = "/" + pageName + "-dao/src/main/java/cn/wx/mzpro/" + xxx;
	private static final String mapperModuleRootPackage = "/" + pageName + "-dao/src/main/resources/mapper/";
	private static final String serviceModuleRootPackage = "/" + pageName + "-service/src/main/java/cn/wx/mzpro/" + xxx;
	private static final String webFrontModuleRootPackage = "/" + pageName + "-front/src/main/java/cn/wx/mzpro/" + xxx;
	static Scanner scanner = new Scanner(System.in);

	/**
	 * <p>
	 * 读取控制台内容
	 * </p>
	 */
	public static String scanner(String tip) {
		StringBuilder help = new StringBuilder();
		help.append("请输入" + tip + "：");
		System.out.println(help.toString());
		return scanner.nextLine();

	}

	/**     =====注意===：
	 * 运行前请阅读，如果用idea开发工具，需要在在Run-Run/Debug Configurations里调整work directory为$MOUDLE_WORKING_DIR$,
	 *               保存然后user.dir就变成子Moudle的根路径了。
	 *               如果用eclipse不用更改
	 * @param
	 */

	public static void main(String[] args) {
		// 代码生成器
		AutoGenerator mpg = new AutoGenerator();

		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		String thisPath = System.getProperty("user.dir");
		java.io.File f = new File(thisPath);
		final String projectPath = f.getParent();
		// gc.setOutputDir(projectPath + "/mybatis-plus-generator/src/main/java");
		gc.setAuthor("");
		gc.setOpen(false);
		// gc.setSwagger2(true);
		gc.setFileOverride(true);
		gc.setActiveRecord(true);// 开启 activeRecord 模式
		gc.setEnableCache(false);// XML 二级缓存
		gc.setBaseResultMap(true);// XML ResultMap
		gc.setBaseColumnList(true);// XML columList
		mpg.setGlobalConfig(gc);

		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();

		dsc.setUrl(dbUrl);
		dsc.setDriverName(dbDriverClass);
		dsc.setUsername(dbUserName);
		dsc.setPassword(dbUserPassword);
		// 定义数据类型匹配
		dsc.setTypeConvert(new MySqlTypeConvert() {
			@Override
			public DbColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
				// System.out.println("转换类型：" + fieldType);
				// tinyint转换成Boolean
				/*
				 * if ( fieldType.toLowerCase().contains( "tinyint" ) ) { return
				 * DbColumnType.BOOLEAN; }
				 */
				// 将数据库中datetime转换成date
				if (fieldType.toLowerCase().contains("datetime")||fieldType.toLowerCase().contains("date")) {
					return DbColumnType.DATE;
				}
				return (DbColumnType) super.processTypeConvert(globalConfig, fieldType);
			}
		});
		mpg.setDataSource(dsc);

		// 包配置
		PackageConfig pc = new PackageConfig();
		pc.setParent(packageName);
		mpg.setPackageInfo(pc);
		if (scanner != null) {
			scanner.close();
		}
		// System.out.println(pc);
		// 自定义配置
		InjectionConfig cfg = new InjectionConfig() {
			@Override
			public void initMap() {
				// to do nothing
			}
		};
		//自定义模板包名
		Map<String, Object> map = new HashMap<>();
		map.put("parentPackage", pc.getParent());
		cfg.setMap(map);

		// 如果模板引擎是 freemarker
		String templatePath = "/templates/mapper.java.ftl";

		// 自定义输出配置
		List<FileOutConfig> focList = new ArrayList<>();
		// 自定义配置会被优先输出
		focList.add(new FileOutConfig(templatePath) {
			@Override
			public String outputFile(TableInfo tableInfo) {
				// 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
				return projectPath + daoModuleRootPackage + "/mapper/" + tableInfo.getEntityName() + "Mapper"
						+ StringPool.DOT_JAVA;

			}

		});
		focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				// 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
				return projectPath + mapperModuleRootPackage + tableInfo.getEntityName() + "Mapper"
						+ StringPool.DOT_XML;

			}

		});
		focList.add(new FileOutConfig("/templates/entity.java.ftl") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				return projectPath + daoModuleRootPackage + "/entity/" + tableInfo.getEntityName()
						+ StringPool.DOT_JAVA;
			}
		});
		focList.add(new FileOutConfig("/templates/service.java.ftl") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				return projectPath + serviceModuleRootPackage + "/service/I" + tableInfo.getEntityName() + "Service"
						+ StringPool.DOT_JAVA;
			}
		});
		focList.add(new FileOutConfig("/templates/serviceImpl.java.ftl") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				return projectPath + serviceModuleRootPackage + "/service/impl/" + tableInfo.getEntityName()
						+ "ServiceImpl" + StringPool.DOT_JAVA;
			}
		});
		focList.add(new FileOutConfig("/templates/controller.java.ftl") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				return projectPath + webFrontModuleRootPackage + "/controller/" + tableInfo.getEntityName()
						+ "Controller" + StringPool.DOT_JAVA;
			}
		});
		cfg.setFileOutConfigList(focList);
		mpg.setCfg(cfg);

		// 配置模板
		TemplateConfig templateConfig = new TemplateConfig();
		// 不生成默认的，则设置为null
		templateConfig.setXml(null);
		templateConfig.setController(null);
		templateConfig.setService(null);
		templateConfig.setServiceImpl(null);
		templateConfig.setMapper(null);
		templateConfig.setEntity(null);

		mpg.setTemplate(templateConfig);

		// 策略配置
		StrategyConfig strategy = new StrategyConfig();

		//strategy.setNaming(NamingStrategy.underline_to_camel);
		//strategy.setColumnNaming(NamingStrategy.underline_to_camel);
		strategy.setNameConvert(new INameConvert() {

			@Override
			public String propertyNameConvert(TableField field) {
				String s = field.getName();
                StringBuilder result = new StringBuilder();
                String[] camels = s.split("_");
                Arrays.stream(camels).filter((camel) -> {
                    return !StringUtils.isEmpty(camel);
                }).forEach((camel) -> {
                    if (result.length() == 0) {
                        result.append(camel);
                    } else {
                        result.append(capitalFirst(camel));
                    }
                });
                s=result.toString();
				if (Character.isLowerCase(s.charAt(0)))
					return s;
				else
					return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1))
							.toString();
			}
			@Override
			public String entityNameConvert(TableInfo tableInfo) {
				String name = tableInfo.getName();
				if (StringUtils.isEmpty(name)) {
					return "";
				} else {
					String tempName = name;
					if (StringUtils.isCapitalMode(name) || StringUtils.isMixedMode(name)) {
						tempName = name.toLowerCase();
					}

					StringBuilder result = new StringBuilder();
					String[] camels = tempName.split("_");
					Arrays.stream(camels).filter((camel) -> {
						return !StringUtils.isEmpty(camel);
					}).forEach((camel) -> {
						if (result.length() == 0) {
							result.append(camel);
						} else {
							result.append(capitalFirst(camel));
						}

					});
					return capitalFirst(result.toString());
				}
			}
		});
		strategy.setEntityLombokModel(true);
		strategy.setRestControllerStyle(true);
		strategy.setControllerMappingHyphenStyle(true);
		if (tables.length > 0) {
			strategy.setInclude(tables);
		}
		if (prefixs.length > 0) {
			strategy.setTablePrefix(prefixs);
		}

		mpg.setStrategy(strategy);
		mpg.setTemplateEngine(new FreemarkerTemplateEngine());
		mpg.execute();
	}
	public static String capitalFirst(String name) {
		return StringUtils.isNotEmpty(name) ? name.substring(0, 1).toUpperCase() + name.substring(1) : "";
	}

}
