package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import threads.BolsaDeTrabajo;
import vista.VentanaSimulacion;

public class ControladorSimulacion implements ActionListener,Observer {
      private VentanaSimulacion vista;
      private ActionListener actionlistener;
	  private BolsaDeTrabajo bolsa;
	
	
      
      
	public ControladorSimulacion() {
		super();
		this.vista = new VentanaSimulacion();
		this.vista.setactionlistener(this);
	}





	@Override
	public void actionPerformed(ActionEvent e) {
		
    if(e.getActionCommand().equalsIgnoreCase("terminar")){
	    	BolsaDeTrabajo.getInstance().setTermina();
	    }
    else if(e.getActionCommand().equalsIgnoreCase(vista.getBtnIrAtras().getActionCommand())) {
    	vista.setVisible(false);
    	vista.repaint();
    	ControladorMain.mostrarVista();
    }
		
	}

	public void agregarObservable(BolsaDeTrabajo bolsa)
    {
	bolsa.addObserver(this);
	this.bolsa = bolsa;
    }
	



	@Override
	public void update(Observable o, Object arg) {
		vista.getContenidolista().addElement((String) arg);
	}

}
