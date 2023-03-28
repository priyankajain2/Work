#include "graph.hpp"
#include <iostream>
#include <sstream>
#include <vector>
#include <list>
#include<algorithm>
// defined std::unique_ptr
#include <memory>
// defines Var and Lit
#include "minisat/core/SolverTypes.h"
// defines Solver
#include "minisat/core/Solver.h"


void Graph::set_vertex(unsigned int num_vertex)
{
    no_of_vertex = num_vertex + 1;
    // adjlist = new std::vector<unsigned int>[num_vertex + 1];
    // std::vector<unsigned int>adjlist[num_vertex + 1];
    adjlist.clear();
    adjlist.resize(no_of_vertex + 1);
    vertcies_of_edges.clear();
}

void Graph::add_edge(unsigned int v_one, unsigned int v_two)
{
    if (v_one <= no_of_vertex && v_two <= no_of_vertex)
    {
        // link the vertex into edge
        adjlist[v_one].push_back(v_two);
        adjlist[v_two].push_back(v_one);
        vertcies_of_edges.push_back(v_one);
        vertcies_of_edges.push_back(v_two);
    }
}

void Graph::shortest_path(unsigned int src, unsigned int dst)
{
    // calculate the shortest path between src and dst
    int pred[no_of_vertex];
    resultant_path.clear();

    if(src == dst){
        std::cout << src << std::endl;
        return;
    }

    if(BFS(src,dst,pred,no_of_vertex,adjlist)==false){
        std::cout << "Error: " << "Path Doesn't Exists" << std::endl;
    }else{
        unsigned int next = dst;
        resultant_path.push_back(next);
        while(pred[next] != -1){
            resultant_path.push_back(pred[next]);
            next = pred[next];
        }

        // std::cout << resultant_path.front() << "-" << std::endl;
        for(unsigned int i = resultant_path.size() ; i > 0; i--){
            if (i ==1){
                std::cout << resultant_path.at(i-1) << std::endl;
            }else{
                std::cout << resultant_path.at(i-1) << "-";
            }
            
        }
    }
}

bool Graph::BFS(unsigned int src, unsigned int dst, int pred[],unsigned int no_of_vertex, std::vector<std::vector<unsigned int>>adjlist){

    bool color[no_of_vertex];
    std::list<unsigned int> Q;

    for(unsigned int i =0; i< no_of_vertex; i++){
        pred[i] = -1;
        color[i] = false;
    }

    color[src] = true;
    Q.push_back(src);

    while(!Q.empty()){
        unsigned int v = Q.front();
        Q.pop_front();
        for(unsigned int i=0; i<adjlist[v].size(); i++){
            if(color[adjlist[v][i]] == false){
                color[adjlist[v][i]] = true;
                pred[adjlist[v][i]] = v;
                Q.push_back(adjlist[v][i]);

                if(adjlist[v][i] == dst){
                    return true;
                }
            }
        }
    }
    return false;

}

void Graph::vertexcover(){

    std::vector<int> vertex_cover_db;
    int k=1;

    while(k<=no_of_vertex){
        std::unique_ptr<Minisat::Solver> solver(new Minisat::Solver());
        Minisat::Var Literals[no_of_vertex][k];

        for(unsigned int i=0; i<no_of_vertex; i++){
            for(unsigned int j=0; j<k; j++){
                Literals[i][j] = solver->newVar();
            }
        }
    
        // 1) At least one vertex is the ith vertex in the vertex cover:
        for(unsigned int i=0; i<k; i++){
            Minisat::vec<Minisat::Lit> at_least_one_vertex;
            for(unsigned int j=0; j<no_of_vertex; j++){
                at_least_one_vertex.push(Minisat::mkLit(Literals[j][i]));
            }
            solver->addClause(at_least_one_vertex);
            at_least_one_vertex.clear();
        }

        // 2) No one vertex can appear twice in a vertex cover.
        for(unsigned int m=0; m<no_of_vertex; m++){
            for(unsigned int p=0; p<k; p++){
                for(unsigned int q=0; q<p; q++){
                    solver->addClause(~Minisat::mkLit(Literals[m][p]), ~Minisat::mkLit(Literals[m][q]));
                }
            }
        }

        // 3) No more than one vertex appears in the mth position of the vertex cover.
        for(unsigned int m=0; m<k; m++){
            for(unsigned int q=0; q<no_of_vertex; q++){
                for(unsigned int p=0; p<q; p++){
                    solver->addClause(~Minisat::mkLit(Literals[p][m]), ~Minisat::mkLit(Literals[q][m]));
                }
            }
        }

        // 4) Every edge is incident to at least one vertex in the vertex cover.
        for(unsigned int i=0; i<vertcies_of_edges.size(); i++){
            Minisat::vec<Minisat::Lit> every_edge_one_vertex;
            for(unsigned int p=0; p<k; p++){
                every_edge_one_vertex.push(Minisat::mkLit(Literals[vertcies_of_edges[i]][p]));
                every_edge_one_vertex.push(Minisat::mkLit(Literals[vertcies_of_edges[i+1]][p]));
            }
            solver->addClause(every_edge_one_vertex);
            every_edge_one_vertex.clear();
            i++;
        }

        vertex_cover_db.clear();
        if (solver->solve()) {
            for (int i = 0; i < no_of_vertex; i++){
                for (int j = 0; j < k; j++){
                    if (Minisat::toInt(solver->modelValue(Literals[i][j])) == 0){
                        vertex_cover_db.push_back(i);
                    }
                }
            }
            std::sort(vertex_cover_db.begin(), vertex_cover_db.end());

            for (int i = 0; i < vertex_cover_db.size(); ++i) {
                std::cout << vertex_cover_db[i] << " ";
            }
            std::cout << "\n"; 
            solver.reset (new Minisat::Solver());
            return;
        }
        else {
            k++;
        }
        
    }

}

bool parse_line(const std::string &line, char &cmd, unsigned int &num_ver, std::string &edge_str, unsigned int &src, unsigned int &dst, std::string &err_msg)
{
    std::istringstream input(line);

    std::ws(input);

    if (input.eof())
    {
        err_msg = "Empty Command";
        return false;
    }

    char ch;
    input >> ch;

    if (input.fail())
    {
        err_msg = "input fail to read";
        return false;
    }

    if (ch == 'V')
    {
        unsigned int n;
        input >> n;
        if (input.fail())
        {
            err_msg = "Missing or bad argument";
            return false;
        }
        std::ws(input);
        if (!input.eof())
        {
            err_msg = "Unexpected argument";
            return false;
        }
        cmd = ch;
        num_ver = n;
        return true;
    }
    else if (ch == 'E')
    {
        std::string edge;
        input >> edge;
        if (input.fail())
        {
            err_msg = "Missing or bad argument";
            return false;
        }
        cmd = ch;
        edge_str = edge;
        return true;
    }
    else if (ch == 's')
    {
        unsigned int s;
        unsigned int d;
        input >> s;
        input >> d;
        if (input.fail())
        {
            err_msg = "Missing or bad argument";
            return false;
        }
        std::ws(input);
        if (!input.eof())
        {
            err_msg = "Unexpected argument";
            return false;
        }
        cmd = ch;
        src = s;
        dst = d;
        return true;
    }
    else
    {
        err_msg = "unknown command";
        return false;
    }
}
