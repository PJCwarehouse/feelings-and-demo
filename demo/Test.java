public class Test {
	public static void main(String[] args) {
		MycloneableObject o = new MycloneableObject();
		MycloneableObject o1 = (MycloneableObject) o.clone();//o1即为克隆体		
		
		o1.value = 20;//value值直接被改变
		o1.values[0] = 100;//values指向的是一个数组，如果是浅复制，那么o和o1指向同一数组，此时o和o1都会改变
						   //如果是深复制，那么o和o1指向不同的数组，只有复制体的值会改变
		System.out.println(o.value);
		System.out.println(o.values[0]);
		System.out.println(o1.value);
		System.out.println(o1.values[0]);		
	}

}
