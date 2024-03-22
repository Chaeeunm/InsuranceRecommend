import { createBrowserRouter, Outlet } from 'react-router-dom';

import RootErrorBoundary from '@/pages/common/components/RootErrorHandler';
import RootSuspense from '@/pages/common/components/RootSuspense';
import ErrorPage from '@/pages/error/components/ErrorPage';
import NotFoundPage from '@/pages/error/components/NotFoundPage';
import Home from '@/pages/home';
import { ToastContainer } from 'react-toastify';
import Example from './pages/example';
import Layout from './components/layout/layout';

const pageRoutes = {
  main: '/',
  example: '/example',
};

const CommonLayout = () => (
  <RootErrorBoundary>
    <RootSuspense>
      <Layout>
        <Outlet />
      </Layout>
      <ToastContainer />
    </RootSuspense>
  </RootErrorBoundary>
);

const router = createBrowserRouter([
  {
    element: <CommonLayout />,
    children: [
      { path: pageRoutes.main, element: <Home />, errorElement: <ErrorPage /> },
      {
        path: pageRoutes.example,
        element: <Example />,
        errorElement: <ErrorPage />,
      },

      { path: '*', element: <NotFoundPage /> },
    ],
  },
]);

export default router;
