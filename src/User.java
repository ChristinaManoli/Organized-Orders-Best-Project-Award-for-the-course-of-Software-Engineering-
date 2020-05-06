import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public abstract class User {
	protected String firstName;
	protected String surName;
	protected String password;
	protected String telephone;
	protected String AMA;
	protected String id;
	protected String company;
	protected int type;
	protected Orders orders = new Orders();
	

	public User(String firstName, String surName, String password, String telephone, String aMA, String id) {
		super();
		this.firstName = firstName;
		this.surName = surName;
		this.password = password;
		this.telephone = telephone;
		AMA = aMA;
		this.id = id;
	
		
	}
	
	public abstract void initializeLists();
	public abstract void refresh();
	public void searchForOrder(String key, int column)
	{
		Boolean found=false;
		ArrayList<Object> ordersKEY = new ArrayList<>();
		if(column==1) {                                      //�� 1 ������o�������� �� �� orderId
			for(Order o : orders.orders)
			{
				if(o.orderId.equals(key))
					{
						ordersKEY.add(o);
						found=true;
					}
			}
		}
		else if (column==2) {                              //�� 2 ������o�������� �� �� supplierId
			for(Order o : orders.orders)
			{
				if(o.supplierId.equals(key)) {
					ordersKEY.add(o);
					found=true;
				}
			}
		}
		else if (column==3) {                              //�� 3 ������o�������� �� �� productId
			for(Order o : orders.orders)
			{
				if(o.productId.equals(key)) {
					ordersKEY.add(o);
					found=true;
				}
			}
		}
		else if (column==4) {                              //�� 4 ������o�������� �� �� productName
			for(Order o : orders.orders)
			{
				if(o.productName.equals(key)) {
					ordersKEY.add(o);
					found=true;
				}
			}
		}
		else if (column==5) {                              //�� 5 ������o�������� �� �� date
			for(Order o : orders.orders)
			{
				if(o.date.equals(key)) {
					ordersKEY.add(o);
					found=true;
				}
			}
		}
		else if (column==6) {                             //�� 6 ������o�������� �� �� status
			int intkey = Integer.parseInt(key);
			for(Order o : orders.orders)
			{
				if(o.status==intkey) ordersKEY.add(o);
			}
		}
		
		Component frame = null;
		if (found) new PresentationForm(ordersKEY);
		else JOptionPane.showMessageDialog(frame, "No result",
			    "Inane error",
			    JOptionPane.ERROR_MESSAGE);
	}
	public void editOrder(Order o, int index)
	{
		orders.orders.set(index, o);
	}
}
