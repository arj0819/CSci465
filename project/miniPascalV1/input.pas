{You must put tokens in the symbol table
as you are parsing them. Also, there must
be appropriate error handling!}

program example(input,output); {Apparently, program, input and output are reserved words}
    var x,y:integer;
    n: array [1..20] of integer;
    hi:= 'Hello, World!':string;
    q:='q':char;
    result:=true:boolean;
    antiresult:=false:boolean;
    pi:= 3.14159:real;%
    arrayOfChars: array[1..5] of char;
    function gcd(a,b:integer):integer;
    begin{gcd}
        while b<10 do
        begin{while}
            if (a>0) then
                a:=a+1;
            if (b<>-1) then
                b:=a*2;
            if (c>=0) then    
                c:=b-a;
            if (d<=1000) then
                d:=a/c mod 2;
            else
                e:=-200;
        end;{while}
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
