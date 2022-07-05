package modelo;

import excepciones.IncrementoImposibleException;

public interface Movible extends Cloneable
{

	double getX();

	//void setX(double x);

	double getY();

	//void setY(double y);

	double distancia(Movible otro);

	void mueve(double x, double y);
	
	void incrementaPos(double valorX, double valorY) throws IncrementoImposibleException;

	Object clone() throws CloneNotSupportedException;

	
}