package org.webank.working.thinking.enums;

import org.webank.working.thinking.tools.OutputUtils;

enum Shrubbery
{
	GROUND, CRAWLING, HANGING;

	@Override
	public String toString()
	{
		String id = this.name();
		return id.charAt(0) + id.substring(1).toLowerCase();
	}

	public static void main(String[] args)
	{
		OutputUtils.print("hello world main function");
	}
}

public class EnumFeature
{
	public static void main(String[] args)
	{
		for (Shrubbery shrubbery : Shrubbery.values())
		{
			OutputUtils.print(shrubbery + " ordinal(所处位置):" + shrubbery.ordinal());
			OutputUtils.print(shrubbery.compareTo(Shrubbery.GROUND) + "");
			OutputUtils.print(shrubbery.equals(Shrubbery.GROUND) + "");
			OutputUtils.print((shrubbery == Shrubbery.GROUND) + "");

			// 注意这里，enum也是一个类，所以你可以在里面添加任何可以在类中添加的东西，比如说方法
			OutputUtils.print("DeclaringClass:" + shrubbery.getDeclaringClass() + ",SuperClass:"
			        + shrubbery.getDeclaringClass().getSuperclass() + "");

			// name通常会使用的比较频繁
			OutputUtils.print(shrubbery.name());
			OutputUtils.print(shrubbery.toString());
			OutputUtils.print("---------");
		}

		// 跨域下使用静态导入import static xx.xx.*;就可以使用里面所有的枚举类型了
	}
}
