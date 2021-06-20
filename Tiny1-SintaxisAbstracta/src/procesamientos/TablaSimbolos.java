package procesamientos;

import java.util.HashMap;
import java.util.LinkedList;

import asint.Tiny1Asint.Genero;

public class TablaSimbolos {
	
	private LinkedList<HashMap<String, Genero>> ts;
	private int nivel;
	
	public TablaSimbolos() {
		nivel = 0;
		ts = new LinkedList<HashMap<String, Genero>>();
		ts.add(new HashMap<String, Genero>());
	}
	
	public boolean contiene(String id) {
		boolean found = false;
		
		for(int i = nivel; i >= 0 && found == false; i--) {
			found = (ts.get(i).get(id) != null);
		}
		
		return found;
	}
	
	public void add(String id, Genero $) {
		ts.get(nivel).put(id, $);
	}
	
	public Genero valorPara(String id) {
		int i = nivel;
		
		while(i >= 0) {
			if (ts.get(i).get(id) != null){
				return ts.get(i).get(id);
			}
			i--;
		}
		
		return null;
	}
	
}
