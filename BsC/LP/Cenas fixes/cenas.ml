# sum [1;2;3;4;5]
- : int = 15

let sum xs =
	List.fold_left (+) 0 xs;;