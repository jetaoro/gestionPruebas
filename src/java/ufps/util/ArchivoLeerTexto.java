package ufps.util;
import java.io.*;
import java.util.Vector;
public class ArchivoLeerTexto
{
	
	
	private String filename;
	private BufferedReader reader;
	private String delimitador=null;
	private boolean packed = false;
	
	
	public ArchivoLeerTexto(String filename)  //throws IOException
		{
			this.filename=filename;
		}
		
		
	public ArchivoLeerTexto(String filename, String delimitador)  //throws IOException
		{
			this.filename=filename;
			this.delimitador=delimitador;
		}

	public ArchivoLeerTexto(String filename, String delimitador, boolean packed)
		{
			this.filename=filename;
			this.delimitador=delimitador;
                                                      this.packed = packed;
		}

		
	public void open () {
		try {
                if ( !this.packed ) {
                    this.reader=new BufferedReader(new FileReader(filename));
                } else {
                    this.reader=new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(filename)) );
                }

			}
			catch (IOException e) {
				System.err.print(e.toString());
			}
	}
	public String readLine() //throws IOException
		{
		
			try {
				return (this.reader.readLine());
			}
			catch (IOException e) {
					System.err.print(e.toString());
			}
		return null;	
		}
		
	public void close() //throws IOException
		{
			
			try {
				this.reader.close();
			}
			catch (IOException e) {
					System.err.print(e.toString());
			}
		}
		
	
	public String [][]leerTodo() //throws IOException
		{
		
		String Linea=this.readLine();	
		Vector<Vector<String>> r=new Vector<Vector<String>>();
		while(Linea!=null)		
			{
	            String []v=Linea.split(this.delimitador);
				Vector<String> p=new Vector<String>();
				for(String dato:v)
				{
					p.add(dato);
					System.out.print(dato+"-");
				}
	                    
	                        
				r.add(p);
			Linea=this.readLine();		
			}
		
		String matrix[][]=new String[r.size()][];
		int i=0;
		for(Vector<String> v:r)
		{
			
			matrix[i]=new String[v.size()];
			int j=0;
			for(String dato:v)
				matrix[i][j++]=dato;
			i++;
			
		}
		this.close();
		return (matrix);
		}


}
