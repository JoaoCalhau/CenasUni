let () = Printf.printf "Recursivo (Com if-then-else):\n"

let rec fact_rec_if x =
	if x <= 1 then 
		1 
	else 
		x * fact_rec_if (x - 1);;


let () =
	for n = 0 to 16 do
		Printf.printf "%d! = %d\n" n (fact_rec_if n)
	done;


Printf.printf "\n"
let () = Printf.printf "Recursivo (Sem if-then-else):\n"


let fact_rec n =
	let rec loop n acc = match n with
		| 0 -> acc
		| _ -> loop (n - 1) (n * acc)
	in loop n 1;;


let () =
	for n = 0 to 16 do
		Printf.printf "%d! = %d\n" n (fact_rec n)
	done;



Printf.printf "\n"
let () = Printf.printf "Iterativo:\n"


let fact_it n =
	let result = ref 1 in
	for i = 1 to n do
		result := !result * i
	done;
	!result

let () =
	for n = 0 to 16 do
		Printf.printf "%d! = %d\n" n (fact_it n)
	done;