const Loading = ({ isLoading }) => {

    return (
        <div className="relative">
            {isLoading && <div className="fixed inset-0 flex items-center justify-center bg-black opacity-80" style={{ zIndex: 100 }}>
                <div className="text-white text-xl font-semibold animate-pulse">
                    Loading...
                </div>
            </div>}
        </div>
    );
};

export default Loading;