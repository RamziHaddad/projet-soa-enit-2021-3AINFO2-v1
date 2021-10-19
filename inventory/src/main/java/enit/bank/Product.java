import java.util.*;

class Product 
{
  	private int m_prodID;
	private String m_prodName;
	
	Product() {}
	Product(int newID, String newName)	// Overload the constructor
	{
		m_prodID = newID;
		m_prodName = newName;
	}

	// Methods to get and set the values
	public int GetID()  {
		return m_prodID;
	}
	public String GetName() {
		return m_prodName;
	}
	public void SetID(int newID) {
		m_prodID = newID;
	}
	public void SetName(String newName) {
		m_prodName = newName;
	}

	// Method to print out our data
	public void PrintValues() {
		System.out.println(m_prodID + " " + m_prodName);
	}

	// New method to see if two products are equal. 
	public boolean equals(Object otherProduct)
	{
		Product p = (Product) otherProduct;
		return (this.m_prodID == p.m_prodID);
	}
}

class Products
{
	private Vector m_vProds;

	public Products()
	{
		// Constructor just allocates new vector
		m_vProds = new Vector();
	}

	public void AddProduct(int newID, String newName)
	{
		int i;
		Product p;
		
		// Find new position to add element to keep it in
		// sorted order by ID
		for (i=0; i < m_vProds.size(); i++) {
			p = (Product) m_vProds.elementAt(i);
			if (p.GetID() > newID) {
				break;	// insert at position i
			}
		}

		if (i==m_vProds.size()) {
			// In this case we went all the way to the end
			// so just add new element at the end
			m_vProds.addElement(new Product(newID, newName));
		}
		else {
			// In this case insert new element at position i
			m_vProds.insertElementAt(new Product(newID, newName), i);
		}
	}

	public void DeleteProduct(int targetID)
	{
		int i;
		i = m_vProds.indexOf(new Product(targetID,""));
		if (i<0) return;		
		m_vProds.removeElementAt(i);
	}

	public String FindProductName(int targetID)
	{
		int i;
		String s= "";
		i = m_vProds.indexOf(new Product(targetID,""));
		if (i>=0) s = ((Product) m_vProds.elementAt(i)).GetName();
		return s;
	}

	public void PrintProducts()
	{
		Product p;
		for (int i=0; i<m_vProds.size(); i++) {
			p = (Product) m_vProds.elementAt(i);
			p.PrintValues();
		}
	}
}

//merge test