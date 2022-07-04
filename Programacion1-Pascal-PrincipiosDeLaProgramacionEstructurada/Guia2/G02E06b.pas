program G02E06b;
var
a,b,c: char;
begin
readln(a);readln(b);readln(c);
if (a<b) and (b<c) then writeln(a,' < ',b,' < ',c)
else
    if (a<c) and (c<b) then writeln(a,' < ',c,' < ',b)
    else
        if (b<a) and (a<c) then writeln(b,' < ',a,' < ',c)
        else
            if (b<c) and (c<a) then writeln(b,' < ',c,' < ',a)
            else
                if (c<a) and (a<b) then writeln(c,' < ',a,' < ',b)
                else writeln(c,' < ',b,' < ',a);
readln();
end.

