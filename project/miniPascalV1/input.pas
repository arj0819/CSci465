program example(input,output);
    var x,y:integer;
    function gcd(a,b:integer):integer;
    begin{gcd}
        if b=0then gcd:=a else gcd:=(b,a mod b)
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