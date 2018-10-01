program example(input,output);
    var x,y:integer;
    n: array [1..20] of integer;
    chararray: array[char] of 1..26;
    arrayOfChars: array[char] of 1..5;
    function gcd(a,b:integer):integer;
    begin{gcd}
        while b<10 do
        begin
            a:=a+1;
            b:=a*2;
            c:=b-a;
            d:=a/c;
        end;
    end;{gcd}
    begin{example}
        read(x,y);
        write(gcd(x,y))
end.
(* 
    This is a bigram comment. It can
    be on multiple lines.
*)
{
    This is a standard curly bracket comment.
    It also be on multiple lines.
}