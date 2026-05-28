package datastr;

public class MyGraph<Ttype> {

	private MyVerticeNode<Ttype>[] verticeNodes;
	private final int DEFAULT_SIZE = 10;
	private int size = DEFAULT_SIZE;
	private int howManyElements = 0;
	
	public int getHowManyElements() {
		return howManyElements;
	}
	
	public MyGraph() {
		verticeNodes = new MyVerticeNode[size];
	}
	
	public MyGraph(int size) {
		if(size > 0) {
			this.size = size;
		}
		verticeNodes = new MyVerticeNode[this.size];
	}
	
	private boolean isEmpty() {
		return (howManyElements == 0);
	}
	
	private boolean isFull() {
		return (howManyElements==size);
	}
	
	private void resize() {
		int newSize = (howManyElements < 200) ? (size * 2) : (int)(size * 1.5);
		MyVerticeNode<Ttype>[] newVerticeNodes= new MyVerticeNode[newSize];
		
		for(int i = 0; i < howManyElements; i++) {
			newVerticeNodes[i] = verticeNodes[i];
		}
		
		verticeNodes = newVerticeNodes;
		size = newSize;	
		System.gc();
		
	}
	
	public void addVertice(Ttype element) throws Exception{
		if(element == null) {
			throw new Exception("Ievades dati nav korekti");
		}
		
		int indexOfVertice = findVerticeIndex(element);
		if(indexOfVertice != -1) {
			throw new Exception("Tāda virsotne " + element + " jau eksistē grafā");
		}
		
		if(isFull()) {
			resize();
		}
		MyVerticeNode<Ttype> newVerticeNode = new MyVerticeNode<Ttype>(element);
		verticeNodes[howManyElements] = newVerticeNode;
		howManyElements++;
		
	}
	
	private int findVerticeIndex(Ttype element) {
		
		for(int i = 0; i < howManyElements; i++) {
			if(verticeNodes[i].getVerticeElement().equals(element)) {
				return i;
			}
		}
		
		return -1;
		
	}
	
	
	public void addEdge(Ttype elementFrom, Ttype elementTo, float weight) 
	throws Exception{
		if(elementFrom == null || elementTo == null || weight <= 0) {
			throw new Exception("Ievades dati nav korekti");
		}
		
		if(isEmpty()) {
			throw new Exception("Grafs ir tukšs un nav iespējams izveidot saites");
		}
		
		int indexOfElementFrom = findVerticeIndex(elementFrom);
		int indexOfElementTo = findVerticeIndex(elementTo);
		if(indexOfElementFrom == -1 || indexOfElementTo == -1) {
			throw new Exception("Kāds no elementiem grafā neeksistē");
		}
		
		if(elementFrom.equals(elementTo)) {
			throw new Exception("Nav iespējams veidot cilpas jeb saiti uz sevi pašu");
		}
		
		MyEdgeNode tempEdgeNode 
			= verticeNodes[indexOfElementFrom].getFirstEdgeNode();
		
		//pirmais saišu bloks
		if(tempEdgeNode == null) {
			MyEdgeNode newEdgeNode = new MyEdgeNode(indexOfElementTo, weight);
			verticeNodes[indexOfElementFrom].setFirstEdgeNode(newEdgeNode);
		}
		else//jau kārtējais saišu bloks
		{
			while(tempEdgeNode.getNextEdge() != null) {
				if(tempEdgeNode.getIndexToVertice() == indexOfElementTo
						&& tempEdgeNode.getWeight() == weight) {
					throw new Exception("Tāda saite jau eksistē");
				}
				
				tempEdgeNode = tempEdgeNode.getNextEdge();
			}
			
			MyEdgeNode newEdgeNode = new MyEdgeNode(indexOfElementTo, weight);
			tempEdgeNode.setNextEdge(newEdgeNode);
			
		}
		
	
		
		
	}
	
	
	public void print() throws Exception {
		if(isEmpty()) {
			throw new Exception("Grafs ir tukšs un to nevar izprintēt");
		}
		
		for(int i = 0; i < howManyElements; i++) {
			System.out.print(verticeNodes[i].getVerticeElement() + " ->");
			
			MyEdgeNode currentEdgeNode = verticeNodes[i].getFirstEdgeNode();
			
			while(currentEdgeNode != null) {
				System.out.print(
				"[" +currentEdgeNode.getIndexToVertice()+ "] "+
				currentEdgeNode.getWeight() + " km");
				currentEdgeNode = currentEdgeNode.getNextEdge();
			}
		}
		
	}
	
	
	
	
	
	
}
