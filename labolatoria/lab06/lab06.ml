type 'a lBinaryTree = Empty | Node of 'a * (unit -> 'a lBinaryTree) * (unit -> 'a lBinaryTree);;

let rec lFrom k = Node(k, (fun () -> lFrom (2 * k)) , (fun () -> lFrom (2 * k + 1)));;

let rec takeNlevels n tree =
  if n <= 0 then
    Empty
  else
    match tree with
    | Empty -> Empty
    | Node (value, left, right) ->
        Node (value, (fun () -> takeNlevels (n - 1) (left())), (fun () -> takeNlevels (n - 1) (right())));;

let rec treeFoldL f acc tree =
  match tree with
  | Empty -> acc
  | Node (value, left, right) ->
      let left' = treeFoldL f acc (left()) in
      let calculated = f left' value in
      treeFoldL f calculated (right());; 


let unregular =
  Node(1,
       (fun () ->
          Node(2,
               (fun () ->
                  Node(4,
                       (fun () -> Empty),
                       (fun () -> Empty)
                      )
               ),
               (fun () -> Empty)
              )
       ),
       (fun () ->
          Node(3,
               (fun () ->
                  Node(5,
                       (fun () -> Empty),
                       (fun () ->
                          Node(6,
                               (fun () -> Empty),
                               (fun () -> Empty)
                              )
                       )
                      )
               ),
               (fun () -> Empty)
              )
       ) 
      );;


treeFoldL (fun acc x -> acc @ [x]) [] (takeNlevels 0 (lFrom 1));; 
treeFoldL (fun acc x -> acc @ [x]) [] (takeNlevels 1 (lFrom 1));;
treeFoldL (fun acc x -> acc @ [x]) [] (takeNlevels 2 (lFrom 1));;
treeFoldL (fun acc x -> acc @ [x]) [] (takeNlevels 3 (lFrom 1));;
treeFoldL (fun acc x -> acc @ [x]) [] (takeNlevels 4 (lFrom 1));;
treeFoldL (fun acc x -> acc @ [x]) [] unregular;; 