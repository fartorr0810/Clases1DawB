--1.Ejercicio 1
BEGIN 
	IF 10>5 THEN 
	DBMS_OUTPUT.PUT_LINE('Cierto'); 
	ELSE 
	DBMS_OUTPUT.PUT_LINE('Falso');
	END IF;
	END; 

--Cierto
--Devuelve Cierto poque en el if la condicion se cumple, 10 es mayor que 5.

BEGIN
 IF 10>5 AND 5>1 THEN
 	DBMS_OUTPUT.PUT_LINE('Cierto');
 	ELSE 
 	DBMS_OUTPUT.PUT_LINE('Falso');
 	END IF;
 	END;
 --Cierto
 --Devuelve Cierto porque se cumplen las dos condiciones

 BEGIN
 IF 10>5 AND 5>50 
 THEN
  DBMS_OUTPUT.PUT_LINE('Cierto');
  ELSE 
  DBMS_OUTPUT.PUT_LINE('Falso');
  END IF;
  END;
--Falso
--Devuelve falso porque la segunda condicion no se cumple.

BEGIN
 CASE WHEN 10>5 AND 5>50 
 THEN
 DBMS_OUTPUT.PUT_LINE('Cierto');
 ELSE 
 DBMS_OUTPUT.PUT_LINE('Falso');
 END CASE;
 END;
 --Falso
 --Da falso. Porque no cumple la segunda condicion

 BEGIN 
 FOR i IN 1..10 LOOP
  DBMS_OUTPUT.PUT_LINE(i);
  END LOOP;
  END;
--1
--2
--3
--4
--5
--6
--7
--8
--9
--10

  --Un bucle for que imprime del 1 al 10.


  BEGIN FOR i IN REVERSE 1..10 
  LOOP 
  DBMS_OUTPUT.PUT_LINE(i);
  END LOOP;
  END;
  /* 10
9
8
7
6
5
4
3
2
1 */
  --Un bucle for invertido y imprime del 10 al 1

  DECLARE num NUMBER(3):=0;
  BEGIN
   WHILE num<=100
   LOOP 
   DBMS_OUTPUT.PUT_LINE(num);
   num:=num+2;
   END LOOP;
   END;
/* 0
2
4
6
8
10
12
14
16
18
20
22
24
26
28
30
32
34
36
38
40
42
44
46
48
50
52
54
56
58
60
62
64
66
68
70
72
74
76
78
80
82
84
86
88
90
92
94
96
98
100
 */   --Cuenta de 2 en 2 hasta el 100 declarando una variable y con el while que se ejecutara hasta que la variable num
   --llegue a 100.

DECLARE 
num NUMBER(3):=0;
BEGIN
 LOOP DBMS_OUTPUT.PUT_LINE(num);
 IF num>100 THEN EXIT;
 END IF;
 num:=num+2;
 END LOOP;
 END;
/* 0
2
4
6
8
10
12
14
16
18
20
22
24
26
28
30
32
34
36
38
40
42
44
46
48
50
52
54
56
58
60
62
64
66
68
70
72
74
76
78
80
82
84
86
88
90
92
94
96
98
100
102 
 */  --Imprime hasta 102, con un do while 
 DECLARE num NUMBER(3):=0;
 BEGIN
  LOOP DBMS_OUTPUT.PUT_LINE(num);
  EXIT WHEN num>100;
  num:=num+2;
  END LOOP;
  END;
/* 0
2
4
6
8
10
12
14
16
18
20
22
24
26
28
30
32
34
36
38
40
42
44
46
48
50
52
54
56
58
60
62
64
66
68
70
72
74
76
78
80
82
84
86
88
90
92
94
96
98
100
102 */
  --Otro bucle que imprime hasta 102 con un do while
  
