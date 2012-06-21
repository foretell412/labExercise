
public class MyLinkedList implements CpsfSimpleList{
	MyLinkedList next;
	MyLinkedList prev;
	Object data;
	public MyLinkedList(){
		next=null;
		prev=null;
	}
	public MyLinkedList(Object data,MyLinkedList next,MyLinkedList prev){
		this.data=data;
		this.next=next;
		this.prev=prev;
	}
	public Object get(int index){
		MyLinkedList root=this;
		int i=-1;
		while (i<index&&root!=null){
			root=root.next;
			i++;
		}
		if (root==null) {
			System.out.println("This element don't exist");
			return null;
		}
		else {
			//System.out.println("Element["+index+"]="+root.data);
			return root.data;
		}
	}
	public void add(Object data){
		MyLinkedList root=this;
		while (root.next!=null){
			root=root.next;
		}
		MyLinkedList newElement= new MyLinkedList(data,null,root);
		root.next=newElement;
		
	}
	public void remove(int index){
		MyLinkedList root=this;
		MyLinkedList tempNext,tempPrev;
		int i=-1;
		while (i<index&&root!=null){
			root=root.next;
			i++;
		}
		if (root==null) {
			System.out.println("This element don't exist");
		}
		else{
			tempNext=root.next;
			tempPrev=root.prev;
			if (tempPrev!=null) tempPrev.next=tempNext;
			if (tempNext!=null) tempNext.prev=tempPrev;
			System.out.println("Remove element["+i+"]");
		}
	}
	
	public int size(){
		MyLinkedList root=this;
		int i=0;
		while (root!=null){
			root=root.next;
			i++;
		}
		return i-1;
	}
	public void print(){
		MyLinkedList root=this;
		int i=0;
		while (root!=null){
			if (root.data!=null) System.out.print(""+root.data+" ");
			root=root.next;
			i++;
		}
		System.out.println();
		System.out.println("Total: "+(i-1)+" element(s)");
	}
	public static void main(String[] args){
		MyLinkedList snipperList = new MyLinkedList();
		snipperList.add(1);
		snipperList.add(3);
		snipperList.add(5);
		snipperList.add(7);
		snipperList.add(2);
		snipperList.add(4);
		snipperList.add(6);
		snipperList.add(8);
		snipperList.add(9);
		snipperList.print();
		System.out.println();
		snipperList.remove(2);
		snipperList.print();
		System.out.println();
		snipperList.remove(3);
		snipperList.print();
		System.out.println();
		System.out.println("Element[4]= "+snipperList.get(4));
		System.out.println("Element[9]= "+snipperList.get(9));
		System.out.println("Number of elements ="+snipperList.size());

		
	}

}
