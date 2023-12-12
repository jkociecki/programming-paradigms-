type 'a bt = Empty | Node of 'a * 'a bt * 'a bt

let rec internal_path_length tree =
  let rec ipl_helper depth = function
    | Empty -> 0
    | Node (_, left, right) -> depth + ipl_helper (depth + 1) left + ipl_helper (depth + 1) right
  in
  ipl_helper 0 tree

let rec external_path_length tree =
  let rec epl_helper depth = function
    | Empty -> depth
    | Node (_, left, right) -> epl_helper (depth + 1) left + epl_helper (depth + 1) right
  in
  epl_helper 0 tree

let t = Node(1,Node(2,Empty,Node(3,Empty,Empty)),Empty);;

(* Przykład użycia dla drzewa tt *)
let tt =
  Node(1,
       Node(2,
            Node(4,
                 Empty,
                 Empty
                ),
            Empty
           ),
       Node(3,
            Node(5,
                 Empty,
                 Node(6,
                      Empty,
                      Empty
                     )
                ),
            Empty
           )
      );;

let ipl = internal_path_length t;;
let epl = external_path_length t;;

Printf.printf "Długość ścieżki wewnętrznej: %d\n" ipl;;
Printf.printf "Długość ścieżki zewnętrznej: %d\n" epl;;

type 'a graph = Graph of ('a ->'a list);;

let depthSearch (Graph succ) startNode =
  let rec search visited node =
    if List.mem node visited then
      []
    else
      node ::
      List.fold_left
        (fun acc neighbor -> acc @ search (node :: visited) neighbor)
        [] (succ node)
  in
  search [] startNode
;;

let g = Graph
(function
0 -> [3]
| 1 -> [0;2;4]
| 2 -> [1]
| 3 -> []
| 4 -> [0;2]
| n -> failwith ("Graph g: node "^string_of_int n^" doesn't exist")
);;

depthSearch g 0;;
