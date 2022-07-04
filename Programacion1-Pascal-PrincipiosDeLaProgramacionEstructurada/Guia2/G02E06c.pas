program G02E06c;
var
a,b,c: char;
begin
readln(a);readln(b);readln(c);
if (a<b) then
    if(b<c) then writeln(a,' < ',b,' < ',c)
    else
        if a<c then writeln(a,' < ',c,' < ',b)
        else writeln(c,' < ',a,' < ',b)
else
    if(a<c) then writeln(b,' < ',a,' < ',c)
    else
        if b<c then writeln(b,' < ',c,' < ',a)
        else writeln(c,' < ',b,' < ',a);
readln();
end.

