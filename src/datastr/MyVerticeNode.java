package datastr;

public class MyVerticeNode<Ttype>{
	private Ttype verticeElement;
	private MyEdgeNode firstEdgeNode = null;
	private boolean isVisited = false;
	
	public Ttype getVerticeElement() {
		return verticeElement;
	}
	public void setVerticeElement(Ttype verticeElement) {
		if(verticeElement!=null) {
			this.verticeElement = verticeElement;
		}
		else
		{
			this.verticeElement = (Ttype) new Object();
		}
		
	}
	public MyEdgeNode getFirstEdgeNode() {
		return firstEdgeNode;
	}
	public void setFirstEdgeNode(MyEdgeNode firstEdgeNode) {
		this.firstEdgeNode = firstEdgeNode;
	}
	
	public boolean isVisited() {
		return isVisited;
	}
	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}
	public MyVerticeNode(Ttype verticeElement) {
		setVerticeElement(verticeElement);
	}
	
	public String toString() {
		String result = verticeElement + "->";
		
		MyEdgeNode currentEdgeNode = firstEdgeNode;
		
		while(currentEdgeNode != null) {
			result += currentEdgeNode.toString();//toString var neizsaukt, bet automātiski izsauksies pats
			result += "->";
			currentEdgeNode = currentEdgeNode.getNextEdge();
		}
		
		return result;
		
	}

}
