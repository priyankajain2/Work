#include <iostream>
#include <sstream>
#include <vector>

#include "graph.hpp"

int main(int argc, char** argv) {

    Graph grh;

    // read from stdin until EOF
    while (!std::cin.eof()) {

        // read a line of input until EOL and store in a string
        std::string line;
        std::getline(std::cin, line);

        // if nothing was read, go to top of the while to check for eof
        if (line.size() == 0) {
            continue;
        }

        char cmd;
        unsigned int ver_num;
        std::string edge_str;
        unsigned int src;
        unsigned int dst;
        std::string err_msg;
        if(parse_line(line,cmd,ver_num,edge_str,src,dst,err_msg)){
            switch (cmd)
            {
            case 'V':
                if(ver_num <= 0){
                    std::cout << "Error: " << "vertex is out of range" << std::endl;
                }else{
                    grh.set_vertex(ver_num);
                }
                break;
            case 's':
                if(ver_num >= 1){
                    if(src >= 1 && dst >=1 && src <= ver_num && dst <= ver_num){
                        grh.shortest_path(src,dst);
                    }else{
                        std::cout << "Error: " << "Wrong source or destination vertex" << std::endl;
                    }
                }else{
                    std::cout << "Error: " << "Graph Doesn't Exist" << std::endl;
                }
                break;
            case 'E':
                std::istringstream input_edge(edge_str);
                
                unsigned int v_one;
                unsigned int v_two;
                char next_char;
                unsigned int vertex_value;

                input_edge >> next_char;     //read '{'

                while(next_char != '}'){
                    input_edge >> next_char;    //either read '<' or '}' 
                    if(next_char == '}'){      // check if no edge is given
                        break;
                    }
                    input_edge >> vertex_value;
                    v_one = vertex_value;
                    input_edge >> next_char;
                    input_edge >> vertex_value;
                    v_two = vertex_value;
                    input_edge >> next_char;
                    input_edge >> next_char;
                    
                    if(v_one > ver_num || v_two > ver_num || v_one < 1 || v_two < 1){
                        std::cout << "Error: " << "vertices are out of range" << std::endl;
                    }else{
                        grh.add_edge(v_one,v_two);    //add the edge in the adjacency list
                    }
                }
                grh.vertexcover();
                break;
            }
        }else{
            std::cout << "Error: " << err_msg << std::endl;
        }
    }
    return 0;
}