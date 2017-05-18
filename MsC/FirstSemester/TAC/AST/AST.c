struct AST {
	name_t name;
	type_t type;

	union {
		struct {
			char *identifier;
			id_data data;
		} id;
		struct {
			struct AST *expression;
		} print;

		//etc
	};
};