program G09E06;
type
  ST15 = String[15];
  VentasEmpleado = record
    Legajo:byte;
    Apellido:ST15;
    Total_Ventas:Real;
    Factura_Mayor:word;
    Importe_FacturaM:Real;
  end;
  Venta = record
    Legajo:byte;
    Factura: word;
    Importe: Real;
  end;
  VentasEmpleados = File of VentasEmpleado;
  Ventas = File of Venta;

Procedure ActualizaArchivo(var Ar1:VentasEmpleados;var Ar2:Ventas; NombreArchivo:ST15);
var
  R1:VentasEmpleado;
  R2:Venta;
  Temp:VentasEmpleados;
  Aux:real;
begin
  Assign(Temp, 'Temp.dat');
  Rewrite(Temp);
  Reset(Ar1);
  Reset(Ar2);
  Read(Ar1,R1);
  Read(Ar2,R2);
  While not eof(Ar1) or eof(Ar2) do
    If R1.Legajo=R2.Legajo then
      begin
        Aux:= R1.Importe_FacturaM;
        while R1.Legajo=R2.Legajo do
          begin
            R1.Total_Ventas:=R1.Total_Ventas+R2.Importe;
            if Aux<R2.Importe then
              begin
                Aux:=R2.Importe;
                R1.Factura_Mayor:=R2.Factura;
                R1.Importe_FacturaM:=Aux;
              end;
            Read(Ar2,R2);
          end;
        write(Temp,R1);
        Read(Ar1,R1);
      end
    else
      if R1.Legajo<R2.Legajo then
        begin
          write(Temp,R1);
          read(Ar1,R1);
        end
      else      {R1.Legajo>R2.Legajo}
        read(Ar1,R1);  {No especifica que hacer si aparecen ventas de un legajo que no existe}
  write(Temp,R1); {graba el sentinela}
  Close(Ar1);
  Close(Ar2);
  Erase(Ar1);  {elimina el archivo}
  Rename(Temp, NombreArchivo);
end;

var
  Ar1:VentasEmpleados;
  Ar2:Ventas;

begin
  Assign(Ar1,'Empleados.Dat');
  Assign(Ar2,'Ventas.Dat');
  ActualizaArchivo(Ar1,Ar2,'Empleados.dat');
end.

