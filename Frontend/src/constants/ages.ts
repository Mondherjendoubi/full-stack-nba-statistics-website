
export const AGES_LIST = Array.from({ length: 25 }, (_, index) => ({
  title: (index + 18).toString(), // Convert to string
  value: index + 18,
}));
