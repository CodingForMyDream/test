package com.qun.designPattern.Facade;

/**
 * 观模式是为了解决类与类之家的依赖关系的，像spring一样，可以将类和类之间的关系配置到配置文件中，而外观模式就是将他们的关系放在一个Facade类中，降低了类类之间的耦合度
 * @author xujian_pc
 */
public class Computer {
	
	private Cpu cpu;
	private Disk disk;
	
	public Computer(){
		this.cpu = new Cpu();
		this.disk = new Disk();
	}
	
	public void startup(){  
        System.out.println("start the computer!");  
        cpu.startUp();  
        disk.startUp();  
        System.out.println("start computer finished!");  
    }  
	
	public static void main(String[] args) {
		Computer cp = new Computer();
		cp.startup();
	}

}
