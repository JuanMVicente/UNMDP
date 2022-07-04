program G03E05;
var
  K,Q, Mul:integer;
  i:byte;
begin
  write('Multiplos de: ');readln(K);
  write('Hasta llegar a: ');readln(Q);
  Mul:=0; i:=1;
  while Mul<Q-K do
  begin
    Mul:=K*i;
    i:=i+1;
    Write(Mul,' ');
  end;
  readln();
end.

