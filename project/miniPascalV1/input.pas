program example(input,output);
    var x,y:integer;
    n: array [1..20] of integer;
    hi: 'Hello, World!':string;
    q:'q':char;
    arrayOfChars: array[1..5] of char;
    function gcd(a,b:integer):integer;
    begin{gcd}
        while b<10 do
        begin
            if (a>0) then
                a:=a+1;
            if (b<>-1) then
                b:=a*2;
            if (c>=0) then    
                c:=b-a;
            if (d<=1000) then
                d:=a/c;
            else
                e:=-200;
        end;
    end;{gcd}
    begin{example}
        read(x,y);
        write(gcd(x,y));
        write(hi)
end.
(* 
    This is a bigram comment. It can
    be on multiple lines.
*)
{
    This is a standard curly bracket comment.
    It also be on multiple lines.
}