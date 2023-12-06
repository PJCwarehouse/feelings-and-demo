public class MycloneableObject implements Cloneable//自带接口，但需要在后面重新定义
{
	int value;
	int [] values;
	public MycloneableObject(){
		value = 10;
		values = new int [2];
	}
	public Object clone() {
		MycloneableObject o = null;//克隆体
		
		try {
			o = (MycloneableObject) super.clone();
			o.values = new int[values.length];//去掉这一段，即为浅复制
			for(int i = 0;i < values.length;i++)
			{
				o.values[i] = values[i];
			}
			
			
			} catch (CloneNotSupportedException e) {			e.printStackTrace();
		}
		
		return o;
	}

}