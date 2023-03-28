#include<string>
#include<vector>
#include <memory>
#include "minisat/core/SolverTypes.h"
#include "minisat/core/Solver.h"

class Graph
{
    unsigned int no_of_vertex;
    std::vector<std::vector<unsigned int>> adjlist;
    std::vector<unsigned int> resultant_path;
    std::vector<int> vertcies_of_edges;

public:
    
    void set_vertex(unsigned int num_vertex);

    void add_edge(unsigned int v_one, unsigned int v_two);

    void shortest_path(unsigned int src, unsigned int dst);

    bool BFS(unsigned int src, unsigned int dst, int pred[],unsigned int no_of_vertex, std::vector<std::vector<unsigned int>> adjlist);

    void vertexcover();
};

bool parse_line(const std::string &line, char &cmd, unsigned int &num_ver, std::string &edge_str, unsigned int &src, unsigned int &dst, std::string &err_msg);