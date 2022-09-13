package com.post.generator.plugin;

import java.util.ArrayList;
import java.util.List;
import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;

public class ControllerGenerator extends PluginAdapter {

	private String targetProject = "src/main/java";
	private String modelPacket;
	private String modelClassName;
	private String modelPropertyName;

	private String daoPacket;
	private String daoClassName;
	private String daoPropertyName;

	private String controllerPackage;
	private String controllerName;

	private String criteriaEquals;
	private String criteriaLike;

	private Boolean generator;

	private Boolean approval = false;

	private String orderByKeys;

	@Override
	public boolean validate(List<String> warnings) {

		// 初始化参数
		System.out.println("-----controller生成器-----");
		controllerPackage = properties.getProperty("controllerPackage");
		criteriaEquals = properties.getProperty("criteriaEquals");
		criteriaLike = properties.getProperty("criteriaLike");
		orderByKeys = properties.getProperty("orderByKeys");
		generator = "true".equals(properties.getProperty("generator"));
		approval = "true".equals(properties.getProperty("approval"));

		return true;
	}

	@Override
	public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {
		List<GeneratedJavaFile> answer = new ArrayList<>();
		System.out.println("-->是否生成Controller:" + generator);

		if (generator) {
			String entityPath = introspectedTable.getBaseRecordType();

			modelPacket = entityPath.substring(0, entityPath.lastIndexOf("."));
			System.out.println("->modelPacket:" + modelPacket);
			modelClassName = entityPath.substring(entityPath.lastIndexOf(".") + 1);
			modelPropertyName = firstCharToLowCase(modelClassName);
			System.out.println("-->modelClassName:" + modelClassName);
			System.out.println("-->modelPropertyName:" + modelPropertyName);
			System.out.println();

			daoPacket = introspectedTable.getDAOInterfaceType();
			daoPacket = daoPacket.substring(0, daoPacket.lastIndexOf("."));
			System.out.println("->daoPacket:" + daoPacket);
			daoClassName = modelClassName + "Mapper";
			daoPropertyName = firstCharToLowCase(modelClassName) + "Mapper";
			System.out.println("-->daoClassName:" + daoClassName);
			System.out.println("-->daoPropertyName:" + daoPropertyName);
			System.out.println();

			System.out.println("->Controller目录:" + controllerPackage);
			controllerName = controllerPackage.concat(".").concat(modelClassName).concat("Controller");
			System.out.println("-->controllerName:" + controllerName);
			System.out.println();
//			FullyQualifiedJavaType model = new FullyQualifiedJavaType(entityPath);

			GeneratedJavaFile generateController = generateController(introspectedTable);
			answer.add(generateController);

		}

		return answer;
	}

	private GeneratedJavaFile generateController(IntrospectedTable introspectedTable) {

		FullyQualifiedJavaType controller = new FullyQualifiedJavaType(controllerName);
		TopLevelClass clazz = new TopLevelClass(controller);

		clazz.setSuperClass("BaseController");
		// 描述类的作用域修饰符
		clazz.setVisibility(JavaVisibility.PUBLIC);

		// =====引入依赖包
		for (String str : getImportList()) {
			clazz.addImportedType(new FullyQualifiedJavaType(str));
		}

		// =====全局标签
		clazz.addAnnotation("@RestController");
		clazz.addAnnotation("@CrossOrigin(allowCredentials = \"true\")");
		clazz.addAnnotation("@RequestMapping(\"/api/" + modelPropertyName + "\")");

		Field daoField = new Field(daoPropertyName, new FullyQualifiedJavaType(daoPacket + "." + daoClassName));

		// =====全局变量
		// 描述成员属性 的注解
		daoField.addAnnotation("@Autowired");

		// 描述成员属性修饰符
		// daoField.setVisibility(JavaVisibility.PRIVATE);
		clazz.addField(daoField);

		if (approval) {
			Field approvalMapperField = new Field("sysSpInfoMapper", new FullyQualifiedJavaType("SysSpInfoMapper"));
			approvalMapperField.addAnnotation("@Autowired");
			clazz.addField(approvalMapperField);
			Field approvalServiceField = new Field("sysSpInfoService", new FullyQualifiedJavaType("SysSpInfoService"));
			approvalServiceField.addAnnotation("@Autowired");
			clazz.addField(approvalServiceField);
		}

		// =====list
		clazz.addMethod(getListMethod(introspectedTable));

		Method updateMethod = getUpdateMethod(introspectedTable);
		if (updateMethod != null) {
			clazz.addMethod(updateMethod);

			Method delMethod = getDelMethod(introspectedTable);
			clazz.addMethod(delMethod);
			Method getGetByIdMethod = getGetByIdMethod(introspectedTable);
			clazz.addMethod(getGetByIdMethod);
		}
		if (approval) {
			Method approvalMethod = getSp(introspectedTable);
			clazz.addMethod(approvalMethod);
			Method toApprovalMethod = getToSp(introspectedTable);
			clazz.addMethod(toApprovalMethod);
		}
		GeneratedJavaFile newJavaFile = new GeneratedJavaFile(clazz, targetProject, context.getJavaFormatter());
		return newJavaFile;
	}

	private Method getListMethod(IntrospectedTable introspectedTable) {
		// 描述 方法名
		Method method = new Method("list");
		this.addMethodJavaDoc(method, "分页查询");
		// 标签
		method.addAnnotation("@RequestMapping(\"list\")");
		method.setVisibility(JavaVisibility.PUBLIC);
		//  入参
		method.addParameter(
				new Parameter(new FullyQualifiedJavaType(modelPacket + "." + modelClassName), modelPropertyName));
		method.addParameter(new Parameter(new FullyQualifiedJavaType("String"), "currentPage"));
		method.addParameter(new Parameter(new FullyQualifiedJavaType("String"), "pageSize"));
		method.addParameter(new Parameter(new FullyQualifiedJavaType("String"), "token"));
		// 返回类型
		FullyQualifiedJavaType methodReturnType = new FullyQualifiedJavaType("String");
		method.setReturnType(methodReturnType);

		List<String> codeBody = new ArrayList();
		codeBody.add("// 当前页码");
		codeBody.add("int pn = 1;");
		codeBody.add("if (StringUtils.isNotBlank(currentPage)) {");
		codeBody.add("pn = Integer.parseInt(currentPage);");
		codeBody.add("}");
		codeBody.add("// 每页记录数");
		codeBody.add("int ps = 10;");
		codeBody.add("if (StringUtils.isNotBlank(pageSize)) {");
		codeBody.add("ps = Integer.parseInt(pageSize);");
		codeBody.add("}");
		codeBody.add("PageHelper.startPage(pn, ps);");
		codeBody.add(modelClassName + "Example example = new " + modelClassName + "Example();");
		codeBody.add("Criteria criteria = example.createCriteria();");

		if (criteriaEquals != null && !criteriaEquals.trim().equals("")) {
			for (String key : criteriaEquals.split(",")) {
				String property = firstChartoUpperCase(introspectedTable.getColumn(key).getJavaProperty());
				if ("java.lang.String"
						.equals(introspectedTable.getColumn(key).getFullyQualifiedJavaType().toString())) {

					if (introspectedTable.getColumn(key).getRemarks() != null
							&& !"".equals(introspectedTable.getColumn(key).getRemarks())) {
						codeBody.add("// " + introspectedTable.getColumn(key).getRemarks());
					}
					codeBody.add("if (StringUtils.isNotBlank(" + modelPropertyName + ".get" + property + "())) {");
					codeBody.add(
							"criteria.and" + property + "EqualTo(" + modelPropertyName + ".get" + property + "());");
					codeBody.add("}");
				}

			}
		}

		if (criteriaLike != null && !criteriaLike.trim().equals("")) {
			for (String key : criteriaLike.split(",")) {
				String property = firstChartoUpperCase(introspectedTable.getColumn(key).getJavaProperty());
				if ("java.lang.String"
						.equals(introspectedTable.getColumn(key).getFullyQualifiedJavaType().toString())) {

					if (introspectedTable.getColumn(key).getRemarks() != null
							&& !"".equals(introspectedTable.getColumn(key).getRemarks())) {
						codeBody.add("// " + introspectedTable.getColumn(key).getRemarks());
					}
					codeBody.add("if (StringUtils.isNotBlank(" + modelPropertyName + ".get" + property + "())) {");
					codeBody.add("criteria.and" + property + "Like(\"%\"+" + modelPropertyName + ".get" + property
							+ "()+\"%\");");
					codeBody.add("}");
				}

			}
		}

		if (orderByKeys != null && !"".equals(orderByKeys)) {
			codeBody.add("example.setOrderByClause(\" " + orderByKeys + " desc\");");
		}

		codeBody.add("");
		method.addBodyLine("Map returnMap = new HashMap();");
		codeBody.add("returnMap.put(\"list\", " + daoPropertyName + ".selectByExample(example));");
		codeBody.add("Map paginationMap = new HashMap();");
		codeBody.add("paginationMap.put(\"total\", " + daoPropertyName + ".countByExample(example));");
		codeBody.add("paginationMap.put(\"pageSize\", ps);");
		codeBody.add("paginationMap.put(\"current\", pn);");
		codeBody.add("returnMap.put(\"pagination\", paginationMap);");
		method.addBodyLines(codeBody);

		method.addBodyLine("return jsonData(returnMap);");
		return method;
	}

	private Method getUpdateMethod(IntrospectedTable introspectedTable) {

		List<IntrospectedColumn> list = introspectedTable.getPrimaryKeyColumns();
		for (IntrospectedColumn column : list) {
			System.out.println("->主键:" + column.getJavaProperty());
		}

		if (list.size() == 0) {
			System.out.println("->" + introspectedTable.getTableConfiguration().getTableName() + ",未找到主键,不符合生成条件");
			return null;

		} else if (list.size() > 1) {
			System.out.println("->" + introspectedTable.getTableConfiguration().getTableName() + ",存在多个主键,不符合生成条件");
			return null;

		}

		// 描述 方法名
		Method method = new Method("saveOrUpdate");
		this.addMethodJavaDoc(method, "根据主键新增或修改");
		// 标签
		method.addAnnotation("@RequestMapping(\"saveOrUpdate\")");
		method.setVisibility(JavaVisibility.PUBLIC);
		//  入参
		method.addParameter(
				new Parameter(new FullyQualifiedJavaType(modelPacket + "." + modelClassName), modelPropertyName));
		method.addParameter(new Parameter(new FullyQualifiedJavaType("String"), "token"));
		// 返回类型
		FullyQualifiedJavaType methodReturnType = new FullyQualifiedJavaType("String");
		method.setReturnType(methodReturnType);

		List<String> codeBody = new ArrayList();
		if (list.size() == 1) {
			codeBody.add("if (" + daoPropertyName + ".selectByPrimaryKey(" + modelPropertyName + ".get"
					+ firstChartoUpperCase(list.get(0).getJavaProperty().toString()) + "()) == null) {");

			codeBody.add(modelPropertyName + ".set" + firstChartoUpperCase(list.get(0).getJavaProperty().toString())
					+ "(StringUtils.getPrimaryKey());");
			codeBody.add(daoPropertyName + ".insert(" + modelPropertyName + ");");

			codeBody.add("} else {");
			codeBody.add(daoPropertyName + ".updateByPrimaryKeySelective(" + modelPropertyName + ");");
			codeBody.add("}");

		}
		method.addBodyLines(codeBody);
		method.addBodyLine("return success();");
		return method;
	}

	public void addMethodJavaDoc(Method method, String desc) {
		method.addJavaDocLine("/**");
		method.addJavaDocLine(" *");
		method.addJavaDocLine(" * @Description " + desc);
		method.addJavaDocLine(" * @author 代码生成工具");
		method.addJavaDocLine(" * @date 2022-01-01 00:00:00");
		method.addJavaDocLine(" */");

	}

	private Method getGetByIdMethod(IntrospectedTable introspectedTable) {

		// 描述 方法名
		Method method = new Method("getById");
		this.addMethodJavaDoc(method, "根据主键获取记录");
		// 标签
		method.addAnnotation("@RequestMapping(\"getById\")");
		method.setVisibility(JavaVisibility.PUBLIC);
		List<IntrospectedColumn> list = introspectedTable.getPrimaryKeyColumns();
		for (IntrospectedColumn column : list) {
			System.out.println("->主键:" + column.getJavaProperty());
		}

		if (list.size() == 0) {
			System.out.println("->" + introspectedTable.getTableConfiguration().getTableName() + ",未找到主键,不符合生成条件");
			return null;
		} else if (list.size() > 1) {
			System.out.println("->" + introspectedTable.getTableConfiguration().getTableName() + ",存在多个主键,不符合生成条件");
			return null;

		}
		//  入参
		method.addParameter(
				new Parameter(new FullyQualifiedJavaType(modelPacket + "." + modelClassName), modelPropertyName));
		method.addParameter(new Parameter(new FullyQualifiedJavaType("String"), "token"));
		// 返回类型
		FullyQualifiedJavaType methodReturnType = new FullyQualifiedJavaType("String");
		method.setReturnType(methodReturnType);
		method.addBodyLine("return jsonData( " + daoPropertyName + ".selectByPrimaryKey(" + modelPropertyName + ".get"
				+ firstChartoUpperCase(list.get(0).getJavaProperty()) + "()));");
		return method;
	}

	private Method getToSp(IntrospectedTable introspectedTable) {

		List<IntrospectedColumn> list = introspectedTable.getPrimaryKeyColumns();
		for (IntrospectedColumn column : list) {
			System.out.println("->主键:" + column.getJavaProperty());
		}

		if (list.size() == 0) {
			System.out.println("->" + introspectedTable.getTableConfiguration().getTableName() + ",未找到主键,不符合生成条件");
			return null;

		} else if (list.size() > 1) {
			System.out.println("->" + introspectedTable.getTableConfiguration().getTableName() + ",存在多个主键,不符合生成条件");
			return null;

		}

		// 描述 方法名
		Method method = new Method("toSp");
		// 标签
		method.addAnnotation("@RequestMapping(\"toSp\")");
		method.setVisibility(JavaVisibility.PUBLIC);
		//  入参
		method.addParameter(
				new Parameter(new FullyQualifiedJavaType(modelPacket + "." + modelClassName), modelPropertyName));
		method.addParameter(new Parameter(new FullyQualifiedJavaType("String"), "submitType"));
		method.addParameter(new Parameter(new FullyQualifiedJavaType("String"), "token"));

		// 返回类型
		FullyQualifiedJavaType methodReturnType = new FullyQualifiedJavaType("String");
		method.setReturnType(methodReturnType);

		List<String> codeBody = new ArrayList();
		if (list.size() == 1) {

			codeBody.add(modelClassName + " oldObject = " + daoPropertyName + ".selectByPrimaryKey(" + modelPropertyName
					+ ".get" + firstChartoUpperCase(list.get(0).getJavaProperty().toString()) + "());");
			codeBody.add("if (\"del\".equals(submitType)) {");
			codeBody.add("sysSpInfoService.toSp(\"api/" + modelPropertyName + "/del\", \"\", oldObject, "
					+ modelPropertyName + ", token);");
			codeBody.add("	} else if (oldObject == null) {");
//			codeBody.add(modelPropertyName + ".set" + firstChartoUpperCase(list.get(0).getJavaProperty().toString())
//					+ "(StringUtils.getPrimaryKey());");
			codeBody.add("sysSpInfoService.toSp(\"api/" + modelPropertyName + "/add\", \"\", oldObject, "
					+ modelPropertyName + ", token);");
			codeBody.add("} else {");
			codeBody.add("sysSpInfoService.toSp(\"api/" + modelPropertyName + "/update\", \"\", oldObject, "
					+ modelPropertyName + ", token);");
			codeBody.add("}");

		}
		method.addBodyLines(codeBody);
		method.addBodyLine("return success();");
		return method;
	}

	private Method getSp(IntrospectedTable introspectedTable) {

		// 描述 方法名
		Method method = new Method("sp");
		// 标签
		method.addAnnotation("@RequestMapping(\"sp\")");
		method.setVisibility(JavaVisibility.PUBLIC);
		//  入参

		method.addParameter(new Parameter(new FullyQualifiedJavaType("String"), "spId"));
		method.addParameter(new Parameter(new FullyQualifiedJavaType("String"), "desc"));
		method.addParameter(new Parameter(new FullyQualifiedJavaType("String"), "result"));
		method.addParameter(new Parameter(new FullyQualifiedJavaType("String"), "token"));

		// 返回类型
		FullyQualifiedJavaType methodReturnType = new FullyQualifiedJavaType("String");
		method.setReturnType(methodReturnType);

		List<String> codeBody = new ArrayList();

		codeBody.add("SysSpInfo sysSpInfo = sysSpInfoMapper.selectByPrimaryKey(spId);");
		codeBody.add("if (!sysSpInfo.getSpResult().equals(\"02\")) {");
		codeBody.add("try {");
		codeBody.add(modelClassName + " " + modelPropertyName + " = JsonUtils.toObject(sysSpInfo.getNewJson(), "
				+ modelClassName + ".class);");
		codeBody.add("if (sysSpInfo.getActionKey().equals(\"api/" + modelPropertyName + "/del\")) {");
		codeBody.add("this.del(" + modelPropertyName + ", sysSpInfo.getCreateToken());");
		codeBody.add("} else {");
		codeBody.add("this.saveOrUpdate(" + modelPropertyName + ", sysSpInfo.getCreateToken());");
		codeBody.add("}");
		codeBody.add("	} catch (Exception e) {");
		codeBody.add("e.printStackTrace();");
		codeBody.add("	result = \"04\";");
		codeBody.add("	desc = \"[\" + Thread.currentThread().getName() + \"]-\" + e.getMessage();");
		codeBody.add("}");
		codeBody.add("sysSpInfoService.sp(sysSpInfo, result, desc, token);");
		codeBody.add("	} else {");
		codeBody.add("return fail(\"系统异常\");");
		codeBody.add("}");

		method.addBodyLines(codeBody);
		method.addBodyLine("return success();");
		return method;
	}

	private Method getDelMethod(IntrospectedTable introspectedTable) {

		List<IntrospectedColumn> list = introspectedTable.getPrimaryKeyColumns();
		for (IntrospectedColumn column : list) {
			System.out.println("->主键:" + column.getJavaProperty());
		}

		if (list.size() == 0) {
			System.out.println("->" + introspectedTable.getTableConfiguration().getTableName() + ",未找到主键,不符合生成条件");
			return null;
		} else if (list.size() > 1) {
			System.out.println("->" + introspectedTable.getTableConfiguration().getTableName() + ",存在多个主键,不符合生成条件");
			return null;

		}

		// 描述 方法名
		Method method = new Method("del");
		this.addMethodJavaDoc(method, "根据主键删除记录");
		// 标签
		method.addAnnotation("@RequestMapping(\"del\")");
		method.setVisibility(JavaVisibility.PUBLIC);
//		if (list.size() == 1) {
		//  入参
		method.addParameter(
				new Parameter(new FullyQualifiedJavaType(modelPacket + "." + modelClassName), modelPropertyName));
		method.addParameter(new Parameter(new FullyQualifiedJavaType("String"), "token"));
		// 返回类型
		FullyQualifiedJavaType methodReturnType = new FullyQualifiedJavaType("String");
		method.setReturnType(methodReturnType);

		method.addBodyLine("return jsonData( " + daoPropertyName + ".deleteByPrimaryKey(" + modelPropertyName + ".get"
				+ firstChartoUpperCase(list.get(0).getJavaProperty()) + "()));");
//		} else {
//			method.addParameter(new Parameter(new FullyQualifiedJavaType(modelPacket + "." + modelClassName + "Key"),
//					modelPropertyName + "Key"));
//			method.addParameter(new Parameter(new FullyQualifiedJavaType("String"), "token"));
//			// 返回类型
//			FullyQualifiedJavaType methodReturnType = new FullyQualifiedJavaType("String");
//			method.setReturnType(methodReturnType);
//
//			method.addBodyLine(
//					"return jsonData( " + daoPropertyName + ".deleteByPrimaryKey(" + modelPropertyName + "Key));");
//		}

		return method;
	}

	private List<String> getImportList() {
		List<String> list = new ArrayList();
		// 工具类
		list.add("java.util.Date");
		list.add("java.util.HashMap");
		list.add("java.util.Map");
		// springboot 标签
		list.add("org.springframework.beans.factory.annotation.Autowired");
		list.add("org.springframework.web.bind.annotation.CrossOrigin");
		list.add("org.springframework.web.bind.annotation.RequestMapping");
		list.add("org.springframework.web.bind.annotation.RestController");
		// 分页
		list.add(" com.github.pagehelper.PageHelper");
		// 工具类
		list.add("com.post.utils.StringUtils");
		list.add("com.post.utils.JsonUtils");

		list.add(daoPacket + "." + daoClassName);
		list.add(modelPacket + "." + modelClassName);
		list.add(modelPacket + "." + modelClassName + "Example");
		list.add(modelPacket + "." + modelClassName + "Example.Criteria");

		if (approval) {
			// 审核流程,根据实际情况添加
			list.add("com.post.entity.SysSpInfo");
			list.add("com.post.dao.SysSpInfoMapper");
			list.add("com.post.service.SysSpInfoService");

		}

		return list;
	}

	private String firstCharToLowCase(String str) {
		char[] chars = new char[1];
		// String str="ABCDE1234";
		chars[0] = str.charAt(0);
		String temp = new String(chars);
		if (chars[0] >= 'A' && chars[0] <= 'Z') {
			return str.replaceFirst(temp, temp.toLowerCase());
		}
		return str;
	}

	private String firstChartoUpperCase(String str) {
		char[] chars = new char[1];
		// String str="ABCDE1234";
		chars[0] = str.charAt(0);
		String temp = new String(chars);
		if (chars[0] >= 'a' && chars[0] <= 'z') {
			return str.replaceFirst(temp, temp.toUpperCase());
		}
		return str;
	}
}