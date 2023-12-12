open Hashtbl

(*zadanie 1*)
let rec stirling(n, m) = 
  match (n, m) with
  | (n, m) when n = m -> 1
  | (_, 0) -> 0
  | (_, 1) -> 1
  | (n, m) -> stirling(n-1, m-1) + m * stirling(n-1, m);;

let t = lazy (stirling(20,5));;  
let getOrReplace hashtable key f =
  if Hashtbl.mem hashtable key then Hashtbl.find hashtable key
  else 
    let new_value = f key in
    Hashtbl.add hashtable key (new_value);
    new_value;;

let memonized_stirling (n, m) =
  let cache = Hashtbl.create 16 in
  let rec stirling_calculate (n, m) = 
    getOrReplace cache (n, m) (fun (n, m) ->
        match (n, m) with
        | (n, m) when n = m -> 1
        | (_, 0) -> 0
        | (_, 1) -> 1
        | (n, m) ->
            stirling_calculate(n-1, m-1) + m * stirling_calculate(n-1, m)
      )in stirling_calculate(n, m);;

memonized_stirling (100 , 5);;
memonized_stirling (400 , 50);;
memonized_stirling (100 , 5);;




(*zadanie 2*)
let rec fibonacci n = 
  if n = 0 then 0
  else if n = 1 then 1
  else fibonacci (n - 1) + fibonacci (n - 2);;
 
let make_memonize (arg: 'a -> 'b) = 
  let func_values = Hashtbl.create 10 in 
  fun (a: 'a) -> 
    if Hashtbl.mem func_values a then Hashtbl.find func_values a
    else 
      let result = arg a in
      Hashtbl.add func_values a result; result;;


let fib_memonized = make_memonize fibonacci;;
fib_memonized 40;;
fib_memonized 40;;
fib_memonized 40;;


(*zadanie 2 inaczej*)
let memo_rec f =
  let cache = Hashtbl.create 16 in
  let rec g elem =
    try Hashtbl.find cache elem
    with Not_found ->
      let result = f g elem in
      Hashtbl.add cache elem result;
      result
  in
  g;;
let fib self = function
  | 0 -> 1
  | 1 -> 1
  | n -> self (n - 1) + self (n - 2);;

let fib_memoized = memo_rec fib 100;;

let resulS = Lazy.force t;;

