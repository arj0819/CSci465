program example(input,output);
    var x,y:integer;
    function gcd(a,b:integer):integer;
    begin{gcd}
        if b=0 then gcd:=a else gcd:=(b,a mod b) {Option1}
        if b<1 then gcd:=c else gcd:=(b,c mod b) {Option2}
        if b<=2 then gcd:=d else gcd:=(b,d mod b) (*Option3*)
        if b<>3.4 then gcd:=e else gcd:=(b,e mod b) (*Option4*)
        if b>5.67 then gcd:=f else gcd:=(b,f mod b) {Option5}
        if b>=8.912 then gcd:=g else gcd:=(b,g mod b) {Option6}
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