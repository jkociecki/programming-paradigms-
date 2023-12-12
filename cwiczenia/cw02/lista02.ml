
(* zadanie 2*)
let rec fib number =
  match number with 
  | 1 -> 1 
  | 0 -> 0
  | _ -> fib (number - 1) + fib (number - 2) ;;

let fibTail number = 
  let rec fib_aux curr prev number =
    match number with
    | 0 -> prev
    | 1 -> curr
    | x -> fib_aux (curr + prev) curr (x - 1) 
  in fib_aux 1 0 number;;

fibTail 42;;


(* zadanie 3*)

let root3 a =
  let epsilon = 1e-15 in
  let rec root3_help x =
    let next_x = x +. (a /. (x *. x) -. x) /. 3.0 in
    if abs_float (next_x *. next_x *. next_x -. a) <= epsilon *. abs_float a then
      next_x
    else
      root3_help next_x
  in
  if a > 1.0 then
    root3_help (a /. 3.0)
  else
    root3_help a;;
root3 16.;;
  
(* zadanie 4*)

let [_; _; x; _; _] = [-2; -1; 0; 1; 2];;
let [ _ ; (x, _)] = [(1,2); (0,1)];;


(* zadanie 5*)
let rec initSegment list1 list2 =
  match list1, list2 with
  |[] , _ -> false
  |_, [] -> true
  |h1::t1, h2::t2 -> 
      if h1 = h2 then initSegment t1 t2
      else false;;

let mylist1 = [1;2;3;4;5;6;7];;
let mylist2 = [1;2;4];;

initSegment mylist1 mylist2;;


(* zadanie 6*)
let rec replaceNth list element number =
  match list, number with
  |[], _ -> []
  |h::t, 0 -> element :: t
  |h::t, x -> h :: replaceNth t element (x-1);;


let mylist2 = [0;1;2;3;4;5;7;8];;
replaceNth mylist2 777 4;;

