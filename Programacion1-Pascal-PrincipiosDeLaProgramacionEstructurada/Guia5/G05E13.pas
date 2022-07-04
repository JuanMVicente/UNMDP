program G05E13;
Type
  TV = Array[1..27] of byte;


Procedure InicializaVector(var A:TV);
var
  i:byte;
begin
  For i:=1 to 27 do
      A[i]:=0;
end;

Procedure LeeFrase(var Cont:TV);
var
  i:byte;
  Car:char;
  Arch:Text;
begin
  Assign(Arch, 'G05E13.txt');
  Reset(Arch);
  While not eof(Arch) do
    begin
      Read(Arch, Car);
      case upcase(Car) of
        'A': cont[1]:=cont[1]+1;
        'B': cont[2]:=cont[2]+1;
        'C': cont[3]:=cont[3]+1;
        'D': cont[4]:=cont[4]+1;
        'E': cont[5]:=cont[5]+1;
        'F': cont[6]:=cont[6]+1;
        'G': cont[7]:=cont[7]+1;
        'H': cont[8]:=cont[8]+1;
        'I': cont[9]:=cont[9]+1;
        'J': cont[10]:=cont[10]+1;
        'K': cont[11]:=cont[11]+1;
        'L': cont[12]:=cont[12]+1;
        'M': cont[13]:=cont[13]+1;
        'N': cont[14]:=cont[14]+1;
        'O': cont[15]:=cont[15]+1;
        'P': cont[16]:=cont[16]+1;
        'Q': cont[17]:=cont[17]+1;
        'R': cont[18]:=cont[18]+1;
        'S': cont[19]:=cont[19]+1;
        'T': cont[20]:=cont[20]+1;
        'U': cont[21]:=cont[21]+1;
        'V': cont[22]:=cont[22]+1;
        'W': cont[23]:=cont[23]+1;
        'X': cont[24]:=cont[24]+1;
        'Y': cont[25]:=cont[25]+1;
        'Z': cont[26]:=cont[26]+1;
      end;
    end;
  close(Arch);
end;

Procedure MuestraVector(A:TV);
var
  i:byte;
  car:char;
begin
  Write('Vector: ', A[1]);
  For i:=2 to 27 do
      Write(' - ',A[i]);
end;

var
  Cont:TV;

begin
  InicializaVector(Cont);
  LeeFrase(Cont);
  MuestraVector(Cont);
  Readln();
end.

