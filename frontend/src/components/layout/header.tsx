import NavLink from '@/components/layout/nav/navLink';

const Header = () => {
  return (
    <header className="bg-orange-500 text-white p-4">
      <h1>OOO</h1>
      <nav className="flex space-x-4">
        <NavLink href="/" variant="blue" label="Home" />
        <NavLink href="/example" variant="blue" label="example" />
      </nav>
    </header>
  );
};

export default Header;
