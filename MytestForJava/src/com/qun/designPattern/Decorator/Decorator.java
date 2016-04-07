package com.qun.designPattern.Decorator;

/**
 * 使用decorator装饰source
 * 装饰器模式的应用场景：
 * 1、需要扩展一个类的功能。
 * 2、动态的为一个对象增加功能，而且还能动态撤销。（继承不能做到这一点，继承的功能是静态的，不能动态增删。）
 * 缺点：产生过多相似的对象，不易排错！ 
 * @author xujian_pc
 */
public class Decorator implements Sourceable {

	@Override
	public void method() {
		System.out.println("before decorator");
		source.method();
		System.out.println("after decorator");
	}
	
	private Source source;

	public Decorator(Source source) {
		super();
		this.source = source;
	}
	
	public static void main(String[] args) {
		Source source = new Source();
		Sourceable sa = new Decorator(source);
		sa.method();
	}

}
