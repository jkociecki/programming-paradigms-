type 'a l_list = LNil | Node of 'a * 'a l_list Lazy.t;;
let rec lfrom k = Node(k, lazy(lfrom (k + 1)));;
let rec ltake = function
    (0, _) -> []
  | (_, LNil) -> []
  | (n, Node(x, lazy xs)) -> x :: ltake(n-1, xs);; 

let lrepeat n list = 
  let rec lrepeat_h times list = 
    match(times, list) with
    | (1, Node(x, lazy fx)) -> Node(x, lazy(lrepeat_h n fx))
    | (n, Node(x, lazy fx)) -> Node(x, lazy(lrepeat_h (times-1) list))
    | (_, LNil) -> LNil 
  in lrepeat_h n list;;

let fibonacci = 
  let rec help a b = 
    Node(a, lazy(help b (a+b))) in help 0 1;;


type 'a l_tree = Empty | TNode of 'a * (unit -> 'a l_tree) * (unit -> 'a l_tree);;

type 'a l_list = LNil | LCons of 'a * (unit -> 'a l_list)

let rec lBreadth tree =
  let rec breadth_aux queue =
    match queue with
    | [] -> LNil
    | TNode (value, left, right) :: rest -> LCons (value, fun () -> breadth_aux (rest @ [left (); right ()]))
    | Empty :: rest -> breadth_aux rest
  in
  breadth_aux [tree];;


let rec lTree n = TNode (n, (function () -> lTree (2 * n)), (function () -> lTree (2 * n + 1)));;