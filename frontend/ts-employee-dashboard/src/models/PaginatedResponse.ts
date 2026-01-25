export type PaginatedResponse = {
  data: any[];
  currentPage: number;
  totalPages: number;
  totalItems: number;
  pageSize: number;
};
