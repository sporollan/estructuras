
package tests.extra;
import lineales.dinamicas.Lista;

public class CambiarPosicion
{
	public static void main(String args[])
	{
		Lista l = new Lista();
		l.insertar('8', 1);
		l.insertar('5', 1);
		l.insertar('3', 1);
		l.insertar('4', 1);
		l.insertar('1', 1);
		l.insertar('2', 1);

		System.out.println(l.toString());

		System.out.println(l.cambiarPosicion(2, 4));

		System.out.println(l.toString());
	}
}

