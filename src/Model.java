
public class Model
{
	private static final String Initial_Value = "0";
	private Integer total;
	
	public Model()
	{
		reset();
	}
	
	public void reset()
	{
		total = new Integer(Initial_Value);
	}
	
	public void multiplyBy(String operand)
	{
		total = total * (new Integer(operand));
	}
	
	public void setValue(String value)
	{
		total = new Integer(value);
	}
	
	public String getValue()
	{
		return total.toString();
	}
	
}
